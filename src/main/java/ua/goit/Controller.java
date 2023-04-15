package ua.goit;

import ua.goit.users.UserService;

import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

public class Controller {
    private final UserService userService = new UserService();

    public void runApp() {
        showInitMessage();
        parseUserCode(getUserInput());
    }

    private void parseUserCode(int code) {
        switch (code) {
            case 4: {
                printResult(userService::getUsers);
                break;
            }
            case 5: {
                printResult(() -> {
                    System.out.println("Enter user ID:");
                    Scanner scanner = new Scanner(System.in);
                    int id = scanner.nextInt();

                    return userService.getUserById(id);
                });
                break;
            }
            case 6: {
                printResult(() -> {
                    System.out.println("Enter username:");
                    Scanner scanner = new Scanner(System.in);
                    String username = scanner.nextLine();

                    return userService.getUserByName(username);
                });
                break;
            }

            default: {
                System.out.println("Unknown code. Try again");
            }
        }

        parseUserCode(getUserInput());
    }

    private void showInitMessage() {
        System.out.println("""
                Enter the number to perform a specific action:
                1 - Creating a new user
                2 - Update user data
                3 - Delete the user
                4 - Get information about all users
                5 - Get information about the user by id
                6 - Get information about the user by username""");
    }

    private int getUserInput() {
        System.out.println("\n\nEnter action number:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private void printResult(Supplier<?> callback) {
        System.out.println("Start loading ...");
        Object result = callback.get();

        if (result instanceof List<?>) {
            ((List<?>) result).forEach(System.out::println);
        } else {
            System.out.println(result);
        }
    }
}
