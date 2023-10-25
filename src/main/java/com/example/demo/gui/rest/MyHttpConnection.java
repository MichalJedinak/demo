package com.example.demo.gui.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyHttpConnection {
       public MyHttpConnection() {
        
    }

    public String getDataFromServer() {
      try {
          String apiUrl = "https://schema.getpostman.com/json/collection/v2.1.0/collection.json";
          URL url = new URL(apiUrl);
          HttpURLConnection connection = (HttpURLConnection) url.openConnection();
          connection.setRequestMethod("GET");
          connection.connect();;
  
          int responseCode = connection.getResponseCode();
          if (responseCode == HttpURLConnection.HTTP_OK) {
              BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
              String inputLine;
              StringBuilder response = new StringBuilder();
  
              while ((inputLine = in.readLine()) != null) {
                  response.append(inputLine);
              }
              in.close();
  
              return response.toString();
          } else {
              System.out.println("Chyba pri získavaní údajov. HTTP kód: " + responseCode);
          }
      } catch (IOException e) {
          e.printStackTrace();
      }
  
      return null; 
  }
  
}
