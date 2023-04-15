package ua.goit.users;

import com.google.gson.reflect.TypeToken;
import ua.goit.dto.UserDto;
import ua.goit.utils.HttpUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class UserService {
    private HttpResponse<String> makeGetRequest (URI uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
        return HttpUtils.CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public List<UserDto> getUsers() {
        try {
            URI uri = new URI(HttpUtils.BASE_URL.append("/users").toString());
            HttpResponse<String> response = makeGetRequest(uri);

            return HttpUtils.gson.fromJson(response.body(), new TypeToken<List<UserDto>>(){}.getType());
        } catch (URISyntaxException | InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public UserDto getUserById(int id) {
        try {
            URI uri = new URI(HttpUtils.BASE_URL.append("/users/").append(id).toString());
            HttpResponse<String> response = makeGetRequest(uri);

            return HttpUtils.gson.fromJson(response.body(), UserDto.class);
        } catch (URISyntaxException | InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<UserDto> getUserByName(String username) {
        try {
            URI uri = new URI(HttpUtils.BASE_URL.append("/users?username=").append(username).toString());
            HttpResponse<String> response = makeGetRequest(uri);

            return HttpUtils.gson.fromJson(response.body(), new TypeToken<List<UserDto>>(){}.getType());
        } catch (URISyntaxException | InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
