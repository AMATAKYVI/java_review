package d12.EnvResources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("--------");

        String filename = "test.txt";

        try {
            byte[] content = Main.class.getResource(filename).openStream().readAllBytes();
            System.out.println(new String(content));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("--------");
        System.out.println(System.getProperty("user.dir") + "/d12/EnvResources/test.txt");
        File file = new File(System.getProperty("user.dir") + "/d12/EnvResources/test.txt");

        if (file.exists()) {
            try {
                byte[] readContent = Files.readAllBytes(file.toPath());
                System.out.println(new String(readContent));
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        } else {
            System.out.println("File does not exist.");
        }

        System.out.println("--------");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

    }

    private static void testFile(String filename) {
        Path path = Paths.get(filename);

        try {
            List<String> lines = Files.readAllLines(path);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("doing domething here");
        }

        System.out.println("file exists we proceed!");
    }
}
