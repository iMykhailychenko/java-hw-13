package ua.goit.utils;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpUtils {
    public static final HttpClient CLIENT = HttpClient.newHttpClient();
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    public static final Gson gson = new Gson();

    public static HttpResponse<String> makeGetRequest(URI uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
        return HttpUtils.CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
