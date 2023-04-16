package ua.goit;

import ua.goit.services.UsersService;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(new View(), new UsersService());
        controller.runApp();
    }
}
