package com.pharm;

import com.vonage.client.VonageClient;
import com.vonage.client.voice.Call;
import com.vonage.client.voice.CallEvent;

public class Main2 {

    public static void main(String[] args) throws InterruptedException {
        //configureLogging();

        final String VONAGE_APPLICATION_ID = "b00f6037-f4f7-422b-8054-96f956b978bf";
        final String VONAGE_PRIVATE_KEY_PATH = "C:/etc/nexmo-sit.pem";
        final String VONAGE_NUMBER = "442037638447";
        final String TO_NUMBER = "443454541111";

        VonageClient client = VonageClient.builder()
                .applicationId(VONAGE_APPLICATION_ID)
                .privateKeyPath(VONAGE_PRIVATE_KEY_PATH)
                .build();
        /*
        Establish a call for testing purposes.
         */
        final String ANSWER_URL = "C:/etc/noccoExample.json";
        CallEvent call = client.getVoiceClient().createCall(new Call(
                TO_NUMBER,
                VONAGE_NUMBER,
                ANSWER_URL
        ));

    }
}
