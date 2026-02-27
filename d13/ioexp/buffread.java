package d13.ioexp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.MatchResult;

public class buffread {

    public static void main(String[] args) {

        String filename = "writingtxt.txt";

        Path base = Paths.get(System.getProperty("user.dir"), "d13", "ioexp");
        Path path = base.resolve(filename).normalize();
        try (BufferedReader br = new BufferedReader(new FileReader(path.toString()))) {
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Done reading ------");

        try (Scanner scanner = new Scanner(new File(path.toString()))) {

            // while (scanner.hasNextLine()) {
            //     String line = scanner.nextLine();
            //     System.out.println(line);
            // }
            scanner.findAll("[A-Za-z]{2,}").map(MatchResult::group)
                    .distinct().sorted().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Done reading ------");

        System.out.println(System.getProperty("file.encoding"));
        System.out.println(Charset.defaultCharset().aliases());
    }
}
