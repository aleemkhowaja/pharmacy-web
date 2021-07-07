package com.pharm;

import com.vonage.client.VonageClient;
import com.vonage.client.voice.Call;
import com.vonage.client.voice.CallEvent;
import com.vonage.client.voice.ncco.InputAction;
import com.vonage.client.voice.ncco.Ncco;
import com.vonage.client.voice.ncco.SpeechSettings;
import com.vonage.client.voice.ncco.TalkAction;

import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        //configureLogging();

        final String VONAGE_APPLICATION_ID = "b00f6037-f4f7-422b-8054-96f956b978bf";
        final String VONAGE_PRIVATE_KEY_PATH = "C:/etc/nexmo-sit.pem";
        final String VONAGE_NUMBER = "442037638447";
        final String TO_NUMBER = "923352692160";

        SpeechSettings speechSettings = new SpeechSettings();
        speechSettings.setLanguage(SpeechSettings.Language.ENGLISH_UNITED_STATES);
        TalkAction intro = TalkAction
                .builder("Please say something")
                .build();


        InputAction input = InputAction.builder()
                .type(Collections.singletonList("speech"))
                .eventUrl(String.format("webhooks/asr"))
                .speech(speechSettings)
                .build();

        VonageClient client = VonageClient.builder()
                .applicationId(VONAGE_APPLICATION_ID)
                .privateKeyPath(VONAGE_PRIVATE_KEY_PATH)
                .build();

        /*
        Establish a call for testing purposes.
         */
        final String ANSWER_URL = "https://nexmo-community.github.io/ncco-examples/long-tts.json";

        Ncco ncco = new Ncco(input);

            CallEvent call = client.getVoiceClient().createCall(new Call(
                TO_NUMBER,
                VONAGE_NUMBER,
                ncco
        ));

        /*
        Give them time to answer.
         */
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String json = "[\n" +
                "  {\n" +
                "    \"action\": \"talk\",\n" +
                "    \"voiceName\": \"Russell\",\n" +
                "    \"text\": \"Thank you for calling. Connecting you to extension.\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"action\": \"connect\",\n" +
                "    \"endpoint\": [\n" +
                "      {\n" +
                "        \"type\": \"vbc\",\n" +
                "        \"extension\": \"1\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]";

        String json1 = "[{\n" +
                "\t\t\"action\": \"connect\",\n" +
                "\t\t\"timeout\": \"45\",\n" +
                "\t\t\"from\": \"442037638447\",\n" +
                "\t\t\"to\": \"443454541111\",\n" +
                "\t\t\"dtmf\": [{\n" +
                "\t\t\t\"digits\": \"1\",\n" +
                "\t\t\t\"timed_out\": \"true\"\n" +
                "\t\t}],\n" +
                "\t\t\"endpoint\": [{\n" +
                "\t\t\t\"type\": \"vbc\",\n" +
                "\t\t\t\"extension\": \"1\"\n" +
                "\t\t}]\n" +
                "\t}\n" +
                "]";

        System.out.println("======================"+json1);

        final String UUID = call.getUuid();
        final String NCCO_URL = "https://nexmo-community.github.io/ncco-examples/talk.json";
        client.getVoiceClient().transferCall(UUID, json1);
    }
}
