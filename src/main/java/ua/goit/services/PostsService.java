package ua.goit.services;

import com.google.gson.reflect.TypeToken;
import ua.goit.dto.PostsDto;
import ua.goit.utils.HttpUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;
import java.util.List;

public class PostsService {
    public List<PostsDto> getPosts(int userId) {
        try {
            URI uri = new URI(HttpUtils.BASE_URL + "/users/" + userId + "/posts");
            HttpResponse<String> response = HttpUtils.makeGetRequest(uri);

            return HttpUtils.gson.fromJson(response.body(), new TypeToken<List<PostsDto>>() {
            }.getType());
        } catch (URISyntaxException | InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
