package ua.goit;

import ua.goit.dto.CommentsDto;
import ua.goit.dto.NewUserDto;
import ua.goit.dto.PostsDto;
import ua.goit.dto.UserDto;
import ua.goit.services.CommentsService;
import ua.goit.services.PostsService;
import ua.goit.services.TodosService;
import ua.goit.services.UsersService;
import ua.goit.utils.FileUtil;
import ua.goit.utils.HttpUtil;

import java.io.IOException;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;


public class Controller {
    private static final String NEW_USER_JSON = "new-user.json";
    private static final String UPDATE_USER_JSON = "update-user.json";

    private final View view;
    private final UsersService userService;
    private final PostsService postsService;
    private final CommentsService commentsService;
    private final TodosService todosService;

    public Controller(View view, UsersService userService, PostsService postsService, CommentsService commentsService, TodosService todosService) {
        this.view = view;
        this.userService = userService;
        this.postsService = postsService;
        this.commentsService = commentsService;
        this.todosService = todosService;
    }

    public void runApp() {
        view.showInitMessage();
        parseUserCode(view.getUserInput());
    }

    public void parseUserCode(int code) {
        switch (code) {
            case 0 -> {
                return;
            }
            case 1 -> {
                createUser();
                break;
            }
            case 2 -> {
                updateUser();
                break;
            }
            case 3 -> {
                deleteUser();
                break;
            }
            case 4 -> {
                view.printResult(userService::getUsers);
                break;
            }
            case 5 -> {
                getUserId();
                break;
            }
            case 6 -> {
                view.printResult(() -> userService.getUserByName(view.getUserName()));
                break;
            }
            case 7 -> {
                getComments();
                break;
            }
            case 8 -> {
                getOpenTasks();
                break;
            }
            case 9 -> {
                view.showInitMessage();
                break;
            }
            default -> {
                System.out.println("Unknown code. Try again");
            }
        }

        parseUserCode(view.getUserInput());
    }

    private void createUser() {
        try {
            String json = FileUtil.readFile(NEW_USER_JSON);
            NewUserDto body = HttpUtil.gson.fromJson(json, NewUserDto.class);
            view.printResult(() -> userService.createUser(body)
                    ? "Success! User created"
                    : "An error occurred"
            );
        } catch (IOException e) {
            System.out.println("Error with file. Make sure you have '" + NEW_USER_JSON + "' file in 'assets' folder");
        }
    }

    private void updateUser() {
        try {
            String json = FileUtil.readFile(UPDATE_USER_JSON);
            UserDto body = HttpUtil.gson.fromJson(json, UserDto.class);

            view.printResult(() -> userService.updateUser(body)
                    ? "Success! User updated"
                    : "An error occurred"
            );
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        } catch (IOException e) {
            System.out.println("Error with file. Make sure you have '" + UPDATE_USER_JSON + "' file in 'assets' folder");
        }
    }

    private void deleteUser() {
        try {
            int userId = view.getUserId();
            view.printResult(() -> userService.deleteUserById(userId)
                    ? "Success! User deleted"
                    : "An error occurred");

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        }
    }

    private void getUserId() {
        try {
            int userId = view.getUserId();
            view.printResult(() -> userService.getUserById(userId));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        }
    }

    private void getComments() {
        try {
            int userId = view.getUserId();

            view.printResult(() -> {
                List<PostsDto> posts = postsService.getPosts(userId);
                Optional<PostsDto> lastPost = posts
                        .stream()
                        .max(Comparator.comparingInt(PostsDto::id));

                if (lastPost.isPresent()) {
                    int postId = lastPost.get().id();
                    List<CommentsDto> comments = commentsService.getComments(postId);

                    FileUtil.writeComments("user-" + userId + "-post-" + postId + "-comments.json", HttpUtil.gson.toJson(comments));
                    return comments;
                } else {
                    return "Something went wrong!";
                }
            });
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        }
    }

    private void getOpenTasks() {
        try {
            int userId = view.getUserId();
            view.printResult(() -> todosService
                    .getTodos(userId)
                    .stream()
                    .filter(i -> !i.completed())
                    .toList());

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        }
    }
}
