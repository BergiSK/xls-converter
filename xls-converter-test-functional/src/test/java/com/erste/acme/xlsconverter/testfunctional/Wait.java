package com.erste.acme.xlsconverter.testfunctional;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.awaitility.Awaitility;

class Wait {

    private static final int TIMEOUT = 30;


    static void untilConverterUp() {
        Awaitility.await().atMost(TIMEOUT, TimeUnit.SECONDS).until(() -> isApplicationUp("http://localhost:8080/actuator/"));
    }

    private static boolean isApplicationUp(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            huc.setRequestMethod("GET");
            huc.connect();
            huc.getResponseCode();
            return true;
        } catch (Exception ex) {
            // ignore
            return false;
        }
    }
}
