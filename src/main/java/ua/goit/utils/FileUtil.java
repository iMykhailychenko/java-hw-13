package ua.goit.utils;

import java.io.*;
import java.nio.file.Paths;

public class FileUtil {
    public static void writeComments(String fileName, String content) {
        File file = new File(fileName);

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

    public static String readFile(String fileName) throws IOException {
        String path = Paths.get("assets", fileName).toString();
        File file = new File(path);

        if (file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line);
            }

            return content.toString();
        }

        throw new IOException();
    }
}
