package ua.goit;

import ua.goit.services.CommentsService;
import ua.goit.services.PostsService;
import ua.goit.services.TodosService;
import ua.goit.services.UsersService;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(
                new View(),
                new UsersService(),
                new PostsService(),
                new CommentsService(),
                new TodosService()
        );
        controller.runApp();
    }
}
