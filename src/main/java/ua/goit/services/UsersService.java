package ua.goit.services;

import com.google.gson.reflect.TypeToken;
import ua.goit.dto.NewUserDto;
import ua.goit.dto.UserDto;
import ua.goit.utils.HttpUtil;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class UsersService {
    public List<UserDto> getUsers() {
        try {
            URI uri = new URI(HttpUtil.BASE_URL + "/users");
            HttpResponse<String> response = HttpUtil.makeGetRequest(uri);

            return HttpUtil.gson.fromJson(response.body(), new TypeToken<List<UserDto>>() {
            }.getType());
        } catch (URISyntaxException | InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public UserDto getUserById(int userId) {
        try {
            URI uri = new URI(HttpUtil.BASE_URL + "/users/" + userId);
            HttpResponse<String> response = HttpUtil.makeGetRequest(uri);

            return HttpUtil.gson.fromJson(response.body(), UserDto.class);
        } catch (URISyntaxException | InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<UserDto> getUserByName(String username) {
        try {
            URI uri = new URI(HttpUtil.BASE_URL + "/users?username=" + username);
            HttpResponse<String> response = HttpUtil.makeGetRequest(uri);

            return HttpUtil.gson.fromJson(response.body(), new TypeToken<List<UserDto>>() {
            }.getType());
        } catch (URISyntaxException | InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean createUser(NewUserDto newUser) {
        try {
            URI uri = new URI(HttpUtil.BASE_URL + "/users");
            String body = HttpUtil.gson.toJson(newUser);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();
            HttpResponse<String> response = HttpUtil.CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

            return response.statusCode() == 201;
        } catch (URISyntaxException | InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateUser(UserDto updatedUser) {
        try {
            URI uri = new URI(HttpUtil.BASE_URL + "/users/" + updatedUser.id());
            String body = HttpUtil.gson.toJson(updatedUser);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .PUT(HttpRequest.BodyPublishers.ofString(body))
                    .build();
            HttpResponse<String> response = HttpUtil.CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

            return response.statusCode() == 200;
        } catch (URISyntaxException | InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteUserById(int userId) {
        try {
            URI uri = new URI(HttpUtil.BASE_URL + "/users/" + userId);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .DELETE()
                    .build();
            HttpResponse<String> response = HttpUtil.CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

            return response.statusCode() == 200;
        } catch (URISyntaxException | InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
