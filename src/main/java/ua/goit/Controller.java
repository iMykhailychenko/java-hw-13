package ua.goit;

import ua.goit.dto.NewUserDto;
import ua.goit.dto.UserDto;
import ua.goit.users.UserService;

import java.util.InputMismatchException;


public class Controller {
    private final View view;
    private final UserService userService;

    public Controller(View view, UserService userService) {
        this.view = view;
        this.userService = userService;
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
                NewUserDto newUserDto = view.generateNewUser();
                view.printResult(() -> userService.createUser(newUserDto)
                        ? "Success! User created"
                        : "An error occurred");
                break;
            }
            case 2 -> {
                try {
                    int userId = view.getUserId();
                    System.out.println("Getting user info ...");
                    UserDto updatedUser = view.updateUserData(userService.getUserById(userId));

                    view.printResult(() -> userService.updateUser(updatedUser) ? "Success! User updated" : "An error occurred");
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                }
                break;
            }
            case 3 -> {
                try {
                    int userId = view.getUserId();
                    view.printResult(() -> userService.deleteUserById(userId) ? "Success! User deleted" : "An error occurred");
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                }
                break;
            }
            case 4 -> {
                view.printResult(userService::getUsers);
                break;
            }
            case 5 -> {
                try {
                    int userId = view.getUserId();
                    view.printResult(() -> userService.getUserById(userId));
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                }
                break;
            }
            case 6 -> {
                view.printResult(() -> userService.getUserByName(view.getUserName()));
                break;
            }
            case 7 -> {
                view.showInitMessage();
                break;
            }
            default -> {
                System.out.println("Unknown code. Try again");
            }
        }

        parseUserCode(view.getUserInput());
    }
}
