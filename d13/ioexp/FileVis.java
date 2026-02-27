package d13.ioexp;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;

public class FileVis {

    public static void main(String[] args) {
        String filename = "writingtxt.txt";
        // File file = new File(filename);
        // try {
        //     if (file.exists()) {
        //         System.out.println("File exists");
        //     } else {
        //         System.out.println("File does not exist");
        //     }
        // } catch (Exception e) {
        //     System.out.println(e.getMessage());
        // }

        if (filename == null || filename.isBlank()) {
            throw new IllegalArgumentException("Filename must not be null or empty");
        }

        // System.out.println("Visiting " + System.getProperty("user.dir") + "/" + filename);
        Path base = Paths.get(System.getProperty("user.dir"), "d13", "ioexp");
        Path path = base.resolve(filename).normalize();
        System.out.println("Visiting " + path);
        try {
            Files.walkFileTree(path, new StatsVisitor());
            System.out.println("Done reading");
        } catch (IOException e) {
            System.out.println("IO error");
            // e.printStackTrace(); // or use a logger
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    private static class StatsVisitor extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
            System.out.println("File: " + file);
            Objects.requireNonNull(file);
            Objects.requireNonNull(attrs);
            System.out.println(file.getFileName());
            return FileVisitResult.CONTINUE;
        }
    }
}
