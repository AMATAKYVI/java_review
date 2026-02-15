package d6.Hash;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactData {

    private static final String phoneData = """
            Charlie Kate, (123) 456-7890
            John Doe, (987) 654-3210
            Bob Smith, (555) 555-5555
            Alice Johnson, (999) 888-7777
            Jane Doe, (111) 222-3333
            Mary Smith, (444) 555-6666
            David Johnson, (777) 888-9999
            Emily Davis, (222) 333-4444
            Robert Smith, (666) 777-8888
            Sarah Johnson, (999) 888-7777
            Michael Davis, (111) 222-3333
            Jennifer Smith, (444) 555-6666
            Daniel Johnson, (777) 888-9999
            Laura Davis, (222) 333-4444
            Thomas Smith, (666) 777-8888
             Mary Smith, (444) 555-6666
            David Johnson, (777) 888-9999
            Emily Davis, (222) 333-4444
            Robert Smith, (666) 777-8888
            Sarah Johnson, (999) 888-7777
            Michael Davis, (111) 222-3333
            Jennifer Smith, (444) 555-6666
            Daniel Johnson, (777) 888-9999
            Laura Davis, (222) 333-4444
            Thomas Smith, (666) 777-8888
            """;

    private static final String emailData = """
            Charlie Kate, 2Hd0N@example.com
            John Doe, qOoRd@example.com
            Bob Smith, 4V9oY@example.com
            Alice Johnson, 1EY3M@example.com
            Jane Doe, 5B0tZ@example.com
            Mary Smith, 6u0tD@example.com
            David Johnson, 6t0o6@example.com
            Emily Davis, 3V5o6@example.com
            Robert Smith, 2oHsQ@example.com
            Sarah Johnson, 6t0o6@example.com
            Michael Davis, 3V5o6@example.com
            Jennifer Smith, 2oHsQ@example.com
            Daniel Johnson, 6t0o6@example.com
            Laura Davis, 3V5o6@example.com
            Thomas Smith, 2oHsQ@example.com
             Robert Smith, 2oHsQ@example.com
            Sarah Johnson, 6t0o6@example.com
            Michael Davis, 3V5o6@example.com
            Jennifer Smith, 2oHsQ@example.com
            Daniel Johnson, 6t0o6@example.com
            Laura Davis, 3V5o6@example.com
            Thomas Smith, 2oHsQ@example.com
             Robert Smith, 2oHsQ@example.com
            Sarah Johnson, 6t0o6@example.com
            Michael Davis, 3V5o6@example.com
            Jennifer Smith, 2oHsQ@example.com
            Daniel Johnson, 6t0o6@example.com
            Laura Davis, 3V5o6@example.com
            Thomas Smith, 2oHsQ@example.com 
            Robert Smith, 2oHsQ@example.com
            Sarah Johnson, 6t0o6@example.com
            Michael Davis, 3V5o6@example.com
            Jennifer Smith, 2oHsQ@example.com
            Daniel Johnson, 6t0o6@example.com
            Laura Davis, 3V5o6@example.com
            Thomas Smith, 2oHsQ@example.com 
            Robert Smith, 2oHsQ@example.com
            Sarah Johnson, 6t0o6@example.com
            Michael Davis, 3V5o6@example.com
            Jennifer Smith, 2oHsQ@example.com
            Daniel Johnson, 6t0o6@example.com
            Laura Davis, 3V5o6@example.com
            Thomas Smith, 2oHsQ@example.com
            """;

    public static List<Contact> getData(String type) {
        List<Contact> dataList = new ArrayList<>();
        Scanner scanner = new Scanner(type.equals("phone") ? phoneData : emailData);

        while (scanner.hasNextLine()) {
            String[] parts = scanner.nextLine().split(",");
            // dataList.add(new Contact(parts[0].trim(), parts[1].trim()));

            String[] trimmedParts = new String[parts.length];
            for (int i = 0; i < parts.length; i++) {
                trimmedParts[i] = parts[i].trim();
            }
            if (type.equals("phone")) {
                dataList.add(new Contact(trimmedParts[0], trimmedParts[1]));
                // dataList.add(new Contact(parts[0], Long.parseLong(parts[1])));
            } else {
                dataList.add(new Contact(trimmedParts[0], trimmedParts[1]));
            }
        }

        return dataList;
    }
}
