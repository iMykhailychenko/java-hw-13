package ua.goit.utils;

import com.google.gson.Gson;

import java.net.http.HttpClient;

public class HttpUtils {
    public static final HttpClient CLIENT = HttpClient.newHttpClient();
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    public static final Gson gson = new Gson();
}
