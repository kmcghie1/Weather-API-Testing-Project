package com.spartaglobal.weather;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

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

//    public static int getStatusCode() {
//        HttpClient httpClient = HttpClient.newHttpClient();
//        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(baseURL))
//    }
}
