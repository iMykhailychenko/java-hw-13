package ua.goit.services;

import com.google.gson.reflect.TypeToken;
import ua.goit.dto.CommentsDto;
import ua.goit.utils.HttpUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;
import java.util.List;

public class CommentsService {
    private List<CommentsDto> getComments(int postId) {
        try {
            URI uri = new URI(HttpUtils.BASE_URL + "/posts/" + postId + "/comments");
            HttpResponse<String> response = HttpUtils.makeGetRequest(uri);

            return HttpUtils.gson.fromJson(response.body(), new TypeToken<List<CommentsDto>>() {
            }.getType());
        } catch (URISyntaxException | InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
