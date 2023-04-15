package ua.goit.utils;

import com.google.gson.Gson;

import java.net.http.HttpClient;

public class HttpUtils {
    public static final HttpClient CLIENT = HttpClient.newHttpClient();
    public static final StringBuilder BASE_URL = new StringBuilder().append("https://jsonplaceholder.typicode.com");
    public static final Gson gson = new Gson();
}
