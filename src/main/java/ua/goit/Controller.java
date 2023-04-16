package ua.goit;

import ua.goit.dto.NewUserDto;
import ua.goit.dto.UserDto;
import ua.goit.services.UsersService;

import java.util.InputMismatchException;


public class Controller {
    private final View view;
    private final UsersService userService;

    public Controller(View view, UsersService userService) {
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
        NewUserDto newUserDto = view.generateNewUser();
        view.printResult(() -> userService.createUser(newUserDto)
                ? "Success! User created"
                : "An error occurred");
    }

    private void updateUser() {
        try {
            int userId = view.getUserId();
            System.out.println("Getting user info ...");
            UserDto updatedUser = view.updateUserData(userService.getUserById(userId));

            view.printResult(() -> userService.updateUser(updatedUser) ? "Success! User updated" : "An error occurred");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        }
    }

    private void deleteUser() {
        try {
            int userId = view.getUserId();
            view.printResult(() -> userService.deleteUserById(userId) ? "Success! User deleted" : "An error occurred");
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
}
