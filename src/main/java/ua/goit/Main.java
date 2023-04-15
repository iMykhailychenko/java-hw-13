package ua.goit;

import ua.goit.dto.UserDto;
import ua.goit.users.UserService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        UserService userService = new UserService();
//
//        List<UserDto> users = userService.getUsers();
//        users.forEach(System.out::println);
//
//        System.out.println("Single User");
//        UserDto user = userService.getSingleUser(6);
//        System.out.println(user);

        Controller controller = new Controller();
        controller.runApp();
    }
}
