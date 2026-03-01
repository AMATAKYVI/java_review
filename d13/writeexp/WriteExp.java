package d13.writeexp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriteExp {

    public static void main(String[] args) {

        System.out.println("--------");

        String todayEvents = """
                1. Coding
                2. Reading
                3. Sleeping
                4. Working
                """;

        String filename = "writingtxt.txt";

        Path base = Paths.get(System.getProperty("user.dir"), "d13", "writeexp");
        Path path = base.resolve(filename).normalize();

        try {
            Files.write(path, todayEvents.getBytes());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
