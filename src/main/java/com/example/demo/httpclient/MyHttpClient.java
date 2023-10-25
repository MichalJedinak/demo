package com.example.demo.httpclient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class MyHttpClient {
    private final HttpClient httpClient;

    public MyHttpClient() {
        this.httpClient = HttpClient.newHttpClient();
    }

    public CompletableFuture< HttpResponse<String> > sendGetRequest(String url) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
    }

    public CompletableFuture<HttpResponse<String>> sendPostRequest(String url, String jsonBody) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();

        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
    }

    public CompletableFuture<HttpResponse<String>> sendPatchRequest(String url, String jsonBody) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .method("PATCH", HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();

        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
    }
    public CompletableFuture< HttpResponse<String> > sendDeleteRequest(String url, String jsonBody){
         HttpRequest request = HttpRequest.newBuilder()
                  .uri(URI.create(url))
                  .header("Content-Type","application/json")
                  .method("DELETE", HttpRequest.BodyPublishers.ofString(jsonBody))
                  .build();

         return httpClient.sendAsync(request,  HttpResponse.BodyHandlers.ofString());
    }

}






