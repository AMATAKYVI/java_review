package d14.RandomAccess;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        String filePath = System.getProperty("user.dir") + "\\d14\\RandomAccess\\file.txt";
        String insertText = "\n\n=== I am the honored one ===\n\n";

        try {
            // Read the entire file
            String originalContent = new String(Files.readAllBytes(Paths.get(filePath)));
            System.out.println("=== Original Content ===");
            System.out.println(originalContent);
            System.out.println("\n=== File size: " + originalContent.length() + " bytes ===\n");

            // Find the middle position
            int middlePosition = originalContent.length() / 2;
            System.out.println("Inserting at position: " + middlePosition);

            // Use RandomAccessFile to insert text at the middle
            insertTextAtPosition(filePath, insertText, middlePosition);

            // Read and display the modified content
            String modifiedContent = new String(Files.readAllBytes(Paths.get(filePath)));
            System.out.println("\n=== Modified Content ===");
            System.out.println(modifiedContent);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Insert text at a specific position in the file using RandomAccessFile
     */
    private static void insertTextAtPosition(String filePath, String textToInsert, int position) throws IOException {
        RandomAccessFile file = new RandomAccessFile(filePath, "rw");

        // Read everything from the insertion point onwards
        file.seek(position);
        byte[] buffer = new byte[(int) (file.length() - position)];
        file.read(buffer);

        // Go back to insertion point and write the new text
        file.seek(position);
        file.writeBytes(textToInsert);

        // Write back the original content that was after the insertion point
        file.write(buffer);

        // Trim the file to the new size
        file.setLength(file.getFilePointer());

        file.close();
        System.out.println("Text inserted successfully at position " + position + "!");
    }
}
