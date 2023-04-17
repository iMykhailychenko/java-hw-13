package ua.goit.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class FileUtil {
    public static void write(String fileName, String content) {
        String path = Paths.get("assets", fileName).toString();
        File file = new File(path);

        try {
            file.createNewFile();
            System.out.println("File " + file.getName() + " created");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(file))) {

            buffer.write(content, 0, content.length());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
