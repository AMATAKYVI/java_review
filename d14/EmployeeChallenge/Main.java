package d14.EmployeeChallenge;

import java.io.RandomAccessFile;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


record Employee(int id, String firstname, String lastname, double salary){

}

public class Main {
     private static final Map<Integer, Long> indexMap = new HashMap<>();

     static {
         int recordsInFile = 0;
         try(RandomAccessFile file = new RandomAccessFile(System.getProperty("user.dir") + "\\d14\\EmployeeChallenge\\employees.dat", "rw")){

            recordsInFile = file.readInt(); // Read the number of records at the beginning of the file
            System.out.println("Building index for " + recordsInFile + " records...");
            
            for (int i = 0; i < recordsInFile; i++) {
                long recordPosition = file.getFilePointer(); // Get the position of the current record
                int id = file.readInt(); // Read the employee ID
                indexMap.put(id, recordPosition); // Store the ID and its position in the index map

                // Read the rest of the record (must match readRecord format!)
                file.readDouble();  // salary - 8 bytes
                file.readUTF();     // lastName - variable length
                file.readUTF();     // firstName - variable length
            }
            System.out.println("Index built successfully! Employee IDs loaded: " + indexMap.keySet());
         }catch (Exception e){
             System.out.println("Error building index: " + e.getMessage());
             e.printStackTrace();
         }
     }

    public static void main(String[] args) {
        System.out.println("Hello Employee Challenge!");
        String filePath = System.getProperty("user.dir") + "\\d14\\EmployeeChallenge\\employees.dat";


        try(RandomAccessFile ra = new RandomAccessFile(filePath, "rw")){
            // Example: Read employee with ID 2
           Scanner scanner = new Scanner(System.in);
           List<Integer> employeeIds = new ArrayList<>(indexMap.keySet());
           Collections.sort(employeeIds);

           while(true){
            System.out.println("Available employee IDs: " + employeeIds);
            if (!scanner.hasNext()) break;
            int employeeId = Integer.parseInt(scanner.nextLine());

            if(employeeId < 1){
                System.out.println("Exiting...");
                break;
            }
            
            if(!employeeIds.contains(employeeId)){
                System.out.println("Employee ID not found. Please try again.");
                continue;
            }

            Employee e = readRecord(ra, employeeId);
            System.out.println("Employee details: " + e);

            try{
                double salary = Double.parseDouble(scanner.nextLine());
                ra.seek(indexMap.get(employeeId) + 4 + 20 + 20); // Move to the salary position
                ra.writeDouble(salary); // Update the salary
                readRecord(ra, employeeId); // Read back the record to confirm update
            }catch (Exception ex){
                System.out.println("Invalid salary input. Please enter a valid number.");
            }
           }
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            // e.printStackTrace();
        }
    }


    private static Employee readRecord(RandomAccessFile ra, int id) throws Exception {
        ra.seek(indexMap.get(id)); // Move the file pointer to the position of the record
        int recordId = ra.readInt(); // Read the employee ID
        double salary = ra.readDouble(); // Read the salary
        String lastName = ra.readUTF(); // Read the last name
        String firstName = ra.readUTF(); // Read the first name

        Employee e = new Employee(recordId, firstName, lastName, salary);
        System.out.println("Read employee: " + e);
        return e;
    }
}
