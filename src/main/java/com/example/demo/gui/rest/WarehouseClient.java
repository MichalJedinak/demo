package com.example.demo.gui.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WarehouseClient {
       public WarehouseClient() {
        try {
            String apiUrl = "http://localhost:8080/item"; 
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();            
            connection.setRequestMethod("POST");
            connection.setRequestMethod("GET");
            connection.setRequestMethod("PATCH");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                System.out.println("Odpoveď zo servera: " + response.toString());
            } else {
                System.out.println("Chyba pri získavaní údajov. HTTP kód: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

      public String getDataFromServer() {
            return null;
      }
}
