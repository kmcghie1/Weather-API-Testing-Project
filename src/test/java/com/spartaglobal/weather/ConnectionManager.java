package com.spartaglobal.weather;

import com.spartaglobal.weather.util.PropertiesLoader;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConnectionManager {
    private static final String baseURL = "https://api.openweathermap.org/data/2.5/";

    public static String getURL() {
        return baseURL;
    }

    public static String getURL(String cityName, String apiKey) {
        return (baseURL + "weather?q=" + cityName + "&appid=" + apiKey);
    }

    public static String getURL(int cityId, String apiKey) {
        return (baseURL + "weather?id=" + cityId + "&appid=" + apiKey);
    }

    public static int getStatusCode(String cityName) {
        String APIKey = PropertiesLoader.getProperties().getProperty("APIKey");
        int statusCode = 0;
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(getURL(cityName, APIKey))).build();
        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            statusCode = httpResponse.statusCode();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return statusCode;
    }
}
