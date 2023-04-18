package ua.goit;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class View {
    public int getUserId() throws InputMismatchException {
        System.out.println("Enter user ID:");
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            throw new InputMismatchException();
        }
    }

    public String getUserName() {
        System.out.println("Enter username:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void printResult(Supplier<?> callback) {
        System.out.println("Start loading ...");
        Object result = callback.get();

        if (result instanceof List<?>) {
            ((List<?>) result).forEach(System.out::println);
        } else {
            System.out.println(result);
        }
    }

    public void showInitMessage() {
        System.out.println("""
                Enter the number to perform a specific action:
                0 - Exit app
                1 - Creating a new user
                2 - Update user data
                3 - Delete the user
                4 - Get information about all users
                5 - Get information about the user by id
                6 - Get information about the user by username
                7 - Get all comments on the user last post
                8 - Get all open tasks""");
    }

    public int getUserInput() {
        System.out.println("\n\n-----------------------------");
        System.out.println("Enter action number [9 - to get help]:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void withUserId(Consumer<Integer> callback) {
        try {
            int userId = getUserId();
            callback.accept(userId);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        }
    }
}
