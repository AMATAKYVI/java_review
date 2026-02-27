package d13.ioexp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        // why relative path does not work here
        String getFullPath = System.getProperty("user.dir") + "/d13/ioexp/testing.csv";
        String filename = "testing.csv";

        File file = new File(filename);

        System.out.println(file.exists());

        useFile(filename);

        String todayEvents = """
                1. Coding
                2. Reading
                3. Sleeping
                4. Working
                """;
        writeToFile(todayEvents, System.getProperty("user.dir") + "/d13/ioexp/writingtxt.txt");

        ///
        /// another exp
        /// 
        String absolutePath = System.getProperty("user.dir") + "/d13/ioexp/writingtxt.txt";

        Path path = Paths.get(absolutePath);
        int pathCount = path.getNameCount();

        for (int i = 0; i < pathCount; i++) {
            System.out.println(".".repeat(i) + " " + path.getName(i));
        }

        Path pathx = Path.of("");

        System.out.println(pathx.toAbsolutePath());

        Stream<Path> paths;
        try {
            paths = Files.list(pathx);
            paths.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("--------");
        String dirContent = listDir(pathx);
        System.out.println(dirContent);
    }

    private static String listDir(Path path) {
        try {
            return Files.list(path).map(Path::toString).collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeToFile(String content, String filename) {
        try {
            File file = new File(filename);

            if (!file.exists()) {
                file.createNewFile();
                System.out.println("File created successfully");
            } else {
                System.out.println("File already exists");
            }

            FileWriter writer = new FileWriter(file, true);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    // private static void writeToFile(String content, String filename) {

    //     File file = new File(filename);
    //     try {
    //         boolean fileExists = file.createNewFile();
    //         if (fileExists) {
    //             System.out.println("File created successfully");
    //         } else {
    //             System.out.println("File already exists");
    //         }
    //         try (java.io.PrintWriter writer = new java.io.PrintWriter(file)) {
    //             writer.append(content);
    //         }
    //     } catch (IOException e) {
    //         System.out.println(e.getMessage());
    //     }
    // }
    private static void useFile(String filename) {
        File file = new File(filename);

        boolean fileExists = file.exists();

        System.out.print(" file exist : " + (fileExists ? "File exists" : "File does not exist"));
    }
}
