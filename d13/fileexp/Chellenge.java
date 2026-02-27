package d13.fileexp;

import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.*;
import java.io.IOException;

public class Chellenge {

    public static void main(String[] args) {

    }

    private static class StatsVisitor implements FileVisitor<Path> {

        private Path initialPath = null;
        private final Map<Path, Map<String, Long>> folderSizes = new LinkedHashMap<>();
        private int initialCount;

        private int printLevel;

        private static final String DIR_CNT = "DirCount";
        private static final String FILE_SIZE = "FileSize";
        private static final String FILE_CNT = "FileCount";

        public StatsVisitor(int printLevel) {
            this.printLevel = printLevel;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            if (initialPath == null) {
                initialPath = dir;
                initialCount = 0;
            }
            return FileVisitResult.CONTINUE;
        }

    }
}
