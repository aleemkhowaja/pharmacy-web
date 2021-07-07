package com.pharm;

import com.vonage.client.incoming.InputEvent;
import com.vonage.client.voice.ncco.DtmfSettings;
import com.vonage.client.voice.ncco.InputAction;
import com.vonage.client.voice.ncco.Ncco;
import com.vonage.client.voice.ncco.TalkAction;
import spark.Route;
import spark.Spark;

import java.util.Collections;

public class Main1 {

    public static void main(String[] args) {
        //configureLogging();

        final String VONAGE_APPLICATION_ID = "b00f6037-f4f7-422b-8054-96f956b978bf";
        final String VONAGE_PRIVATE_KEY_PATH = "C:/etc/nexmo-sit.pem";
        final String VONAGE_NUMBER = "442037638447";
        final String TO_NUMBER = "923352692160";

        /*
         * Route to answer incoming calls.
         */
        Route answerRoute = (req, res) -> {
            TalkAction intro = TalkAction
                    .builder("Hello. Please press any key to continue.")
                    .build();

            DtmfSettings dtmfSettings = new DtmfSettings();
            dtmfSettings.setMaxDigits(1);

            InputAction input = InputAction.builder()
                    .type(Collections.singletonList("dtmf"))
                    .eventUrl(String.format("%s://%s/webhooks/dtmf", req.scheme(), req.host()))
                    .dtmf(dtmfSettings)
                    .build();


            res.type("application/json");

            return new Ncco(intro, input).toJson();
        };

        /*
         * Route which returns NCCO saying which DTMF code was received.
         */
        Route inputRoute = (req, res) -> {
            InputEvent event = InputEvent.fromJson(req.body());

            TalkAction response = TalkAction.builder(String.format("You pressed %s, Goodbye.",
                    event.getDtmf().getDigits()
            )).build();

            res.type("application/json");

            return new Ncco(response).toJson();
        };

        Spark.port(3000);
        Spark.get("/webhooks/answer", answerRoute);
        Spark.post("/webhooks/dtmf", inputRoute);

    }
}
