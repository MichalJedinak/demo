package com.example.demo;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.gui.rest.MyHttpConnection;
import com.example.demo.gui.rest.WarehouseRest;
import com.example.demo.httpclient.MyHttpClient;
@SpringBootApplication
@ComponentScan(basePackages = "com.example.demo")
public class DemoApplication {

	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

		// WarehouseTranscrip transcrip = new WarehouseTranscrip();
		// transcrip.seturl("http://localhost:8080/item");
		// Gson gson = new Gson();
		// String jsonRequest = gson.toJson(transcrip);
		
		MyHttpConnection restClient = new MyHttpConnection();  
		     
		MyHttpClient httpClient = new MyHttpClient();	
		String response = restClient.getDataFromServer();

		String jsonRequest = "http://localhost:8080/item";
		String jsonBody = "{\r\n" + 
		"    \"name\": \"Položka v Sklade\",\r\n" + 
		"    \"available\": 30,\r\n" + //
		"    \"description\":\"Popis položky\"\r\n" +
		"}";
		CompletableFuture<HttpResponse<String>> postResponse = httpClient.sendPostRequest(jsonRequest, jsonBody);
		//System.out.println(jsonRequest);
		postResponse.thenAccept(resp -> {
			int statusCode = resp.statusCode();
			String responseBody = resp.body();
		
		System.out.println("HTTP Status Code: " + statusCode);
		System.out.println("Response Body: " + responseBody);
		});
		
		
		
		if (response != null) {
			System.out.println("Údaje zo servera: " + response);
		  } else {
			System.out.println("Chyba pri získavaní údajov zo servera.");
		  }

		 SpringApplication.run(DemoApplication.class,args); 
		 
	}

}
