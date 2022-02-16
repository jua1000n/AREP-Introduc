package edu.escuelaing.arep.concurrency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class VerifyConcurrencyConect implements Runnable{

    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String GET_URL = "https://arep-backend-jc.herokuapp.com/convert/celsiusF?value=10";
    HttpURLConnection con;
    Thread thread;
    String res;

    public VerifyConcurrencyConect() throws IOException {
        thread = new Thread(this, "my runnable thread");
        URL obj = new URL(GET_URL);
        con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

    }

    @Override
    public void run() {
        int responseCode = 0;
        try {
            responseCode = con.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = null;
            try {
                in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            String inputLine = null;
            StringBuffer response = new StringBuffer();

            while (true) {
                try {
                    if (!((inputLine = in.readLine()) != null)) {
                        break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                response.append(inputLine);
            }
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // print result
            res = response.toString();
            //System.out.println(response.toString());
        } else {
            //System.out.println("GET request not worked");
        }
        //System.out.println("GET DONE");

    }

    public void threadStart() {
        thread.start();
    }

    public void threadRun() {
        thread.run();
    }

    public String getRes() {
        return res;
    }

    public void threadJoin() {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
