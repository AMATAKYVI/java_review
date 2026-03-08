package d14.EmployeeChallenge;

import java.io.RandomAccessFile;

public class WriteEmployees {

    public static void main(String[] args) {
        String filePath = System.getProperty("user.dir") + "\\d14\\EmployeeChallenge\\employees.dat";

        try (RandomAccessFile file = new RandomAccessFile(filePath, "rw")) {
            // Clear the file
            file.setLength(0);

            // Write the number of records first
            file.writeInt(5);  // 5 employees

            // Write employee records: int id, double salary, UTF lastName, UTF firstName
            writeEmployee(file, 730, 75000.50, "Doe", "John");
            writeEmployee(file, 234, 82000.00, "Smith", "Jane");
            writeEmployee(file, 23, 95000.75, "Johnson", "Bob");
            writeEmployee(file, 123, 88000.25, "Williams", "Alice");
            writeEmployee(file, 456, 72000.00, "Brown", "Charlie");

            System.out.println("Successfully wrote 5 employee records to: " + filePath);
            System.out.println("File size: " + file.length() + " bytes");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void writeEmployee(RandomAccessFile file, int id, double salary,
            String lastName, String firstName) throws Exception {
        file.writeInt(id);           // Employee ID
        file.writeDouble(salary);    // Salary
        file.writeUTF(lastName);     // Last name
        file.writeUTF(firstName);    // First name
        System.out.println("Wrote: ID=" + id + ", " + firstName + " " + lastName + ", $" + salary);
    }
}
