package ua.goit.services;

import com.google.gson.reflect.TypeToken;
import ua.goit.dto.TodosDto;
import ua.goit.utils.HttpUtil;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;
import java.util.List;

public class TodosService {
    public List<TodosDto> getTodos(int userId) {
        try {
            URI uri = new URI(HttpUtil.BASE_URL + "/users/" + userId + "/todos");
            HttpResponse<String> response = HttpUtil.makeGetRequest(uri);

            return HttpUtil.gson.fromJson(response.body(), new TypeToken<List<TodosDto>>() {
            }.getType());
        } catch (URISyntaxException | InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
