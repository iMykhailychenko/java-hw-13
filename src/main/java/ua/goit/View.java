package ua.goit;

import ua.goit.dto.*;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
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

    private String getUserInputOrDefault(String message, String defaultValue) {
        System.out.println("\n" + message + " [default '" + defaultValue + "']:");
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();

        if (value.isBlank()) {
            System.out.println("-- The default value will be used: " + defaultValue);
            return defaultValue;
        }

        return value;
    }

    private AddressDto getDefaultAddress() {
        GeoDto geo = new GeoDto(-31.8129, 62.5342);
        return new AddressDto("Skiles Walks", "Suite 351", "Roscoeview", "33263", geo);
    }

    private CompanyDto getDefaultCompany() {
        return new CompanyDto("Keebler LLC", "User-centric fault-tolerant solution", "revolutionize end-to-end systems");
    }

    public NewUserDto generateNewUser() {
        String name = getUserInputOrDefault("Enter name", "Chelsey Dietrich");
        String username = getUserInputOrDefault("Enter username", "Delphine");
        String phone = getUserInputOrDefault("Enter phone", "(254)954-1289");
        String website = getUserInputOrDefault("Enter website", "ola.org");
        String email = getUserInputOrDefault("Enter email", "Lucio_Hettinger@annie.ca");

        return new NewUserDto(name, username, phone, website, email, getDefaultAddress(), getDefaultCompany());
    }

    public UserDto updateUserData(UserDto oldUserData) {
        String name = getUserInputOrDefault("Update name", oldUserData.name());
        String username = getUserInputOrDefault("Update username", oldUserData.username());
        String phone = getUserInputOrDefault("Update phone", oldUserData.phone());
        String website = getUserInputOrDefault("Update website", oldUserData.website());
        String email = getUserInputOrDefault("Update email", oldUserData.email());

        return new UserDto(oldUserData.id(), name, username, phone, website, email, oldUserData.address(), oldUserData.company());
    }
}
