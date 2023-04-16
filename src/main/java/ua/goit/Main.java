package ua.goit;

import ua.goit.users.UserService;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(new View(), new UserService());
        controller.runApp();
    }
}
