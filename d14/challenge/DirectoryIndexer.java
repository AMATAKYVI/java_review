package d14.challenge;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DirectoryIndexer {

    private static final String INDEX_FILE_NAME = "index.txt";
    private static final DateTimeFormatter DATE_FORMATTER
            = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());

    public static void main(String[] args) {
        String baseDir = System.getProperty("user.dir") + "\\d14\\challenge";
        System.out.println("Base directory: " + baseDir);

        // The directories to process
        String[] targetDirs = {"public", "asset", "icon"};

        try {
            for (String dirName : targetDirs) {
                Path dirPath = Paths.get(baseDir, dirName);
                if (Files.exists(dirPath)) {
                    System.out.println("\n=== Processing: " + dirName + " ===");
                    generateIndexForDirectory(dirPath);
                } else {
                    System.out.println("Directory not found: " + dirPath);
                }
            }

            System.out.println("\n=== Index generation complete! ===");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Recursively generate index.txt for a directory and all its subdirectories
     */
    private static void generateIndexForDirectory(Path directory) throws IOException {
        // First, process all subdirectories (bottom-up approach)
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directory)) {
            for (Path path : stream) {
                if (Files.isDirectory(path)) {
                    generateIndexForDirectory(path);
                }
            }
        }

        // Now generate index for current directory
        List<FileInfo> allFiles = collectAllFilesRecursively(directory);
        writeIndexFile(directory, allFiles);

        System.out.println("Generated index for: " + directory);
    }

    /**
     * Collect all files in the directory and subdirectories
     */
    private static List<FileInfo> collectAllFilesRecursively(Path directory) throws IOException {
        List<FileInfo> fileInfos = new ArrayList<>();

        Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                // Skip the index.txt files themselves
                if (!file.getFileName().toString().equals(INDEX_FILE_NAME)) {
                    FileInfo info = new FileInfo(
                            file.toAbsolutePath().toString(),
                            attrs.creationTime().toInstant()
                    );
                    fileInfos.add(info);
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                // Don't skip any directories, but don't add directories themselves
                return FileVisitResult.CONTINUE;
            }
        });

        // Sort by path for consistent ordering
        fileInfos.sort(Comparator.comparing(f -> f.path));

        return fileInfos;
    }

    /**
     * Write the index file
     */
    private static void writeIndexFile(Path directory, List<FileInfo> fileInfos) throws IOException {
        Path indexPath = directory.resolve(INDEX_FILE_NAME);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(indexPath.toFile()))) {
            writer.write("=".repeat(80));
            writer.newLine();
            writer.write("Index for: " + directory.toAbsolutePath());
            writer.newLine();
            writer.write("Generated: " + DATE_FORMATTER.format(Instant.now()));
            writer.newLine();
            writer.write("Total files: " + fileInfos.size());
            writer.newLine();
            writer.write("=".repeat(80));
            writer.newLine();
            writer.newLine();

            for (FileInfo info : fileInfos) {
                writer.write(String.format("%-80s | %s",
                        info.path,
                        DATE_FORMATTER.format(info.creationTime)));
                writer.newLine();
            }
        }
    }

    /**
     * Helper class to store file information
     */
    private static class FileInfo {

        String path;
        Instant creationTime;

        FileInfo(String path, Instant creationTime) {
            this.path = path;
            this.creationTime = creationTime;
        }
    }
}
