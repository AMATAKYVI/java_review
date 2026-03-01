package d14.indexingFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Path;

public class IndexingFile {

    public static void main(String[] args) {

        System.out.println("Hello World!");

        Path path = Path.of("file.txt");
        System.out.println(System.getProperty("user.dir") + "\\d14\\indexingFile\\" + path.toString());

        try (BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\d14\\indexingFile\\" + path.toString()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // System.out.println(line);
            }
        } catch (Exception e) {
            // System.out.println("Error reading file: " + e.getMessage());
            // e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new URL("https://www.merriam-webster.com/dictionary/paragram").openStream()))) {

            String line;
            while ((line = reader.readLine()) != null) {
                // System.out.println(line);
            }
        } catch (Exception e) {
            // System.out.println("Error reading URL: " + e.getMessage());
        }

        // url connection reading with user agent
        try {
            URL url = new URL("https://ai.joinhandshake.com/fellow/projects");
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading URL: " + e.getMessage());
        }

    }
}
