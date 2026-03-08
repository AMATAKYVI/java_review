package d14.dataoutput;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Path dataFile = Path.of(System.getProperty("user.dir") + "\\d14\\dataoutput\\data.dat");
        System.out.println("Data file path: " + dataFile);

        writeData(dataFile);
        readData(dataFile);
        // dateoutputstream and datainputstream are used for writing and reading primitive data types in a portable way.
    }

    private static void writeData(Path filePath) {
        // Example of writing data using DataOutputStream

        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filePath.toFile())))) {
            dos.writeInt(42); // Write an integer
            dos.writeDouble(3.14); // Write a double
            dos.writeUTF("Hello, DataOutputStream!"); // Write a string

            System.out.println("Data written successfully to " + filePath);

            //byte written
            System.out.println("Bytes written: " + dos.size());

        } catch (Exception e) {
        }
    }

    private static void readData(Path filePath) {
        // Example of reading data using DataInputStream
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(filePath.toFile())))) {
            int intValue = dis.readInt(); // Read an integer
            double doubleValue = dis.readDouble(); // Read a double
            String stringValue = dis.readUTF(); // Read a string

            System.out.println("Read data: " + intValue + ", " + doubleValue + ", " + stringValue);

        } catch (Exception e) {
            System.out.println("Error reading data: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
