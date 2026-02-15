package d6.Map;

import java.util.HashMap;
import java.util.Map;

public class MapExp {

    public static void main(String[] args) {

        System.out.println("Hello world!");

        // user has name and contact information (email, phone, address)
        Map<String, String> user = new HashMap<>();

        user.put("name", "John Doe");
        user.put("email", "2dXbD@example.com");
        user.put("phone", "123-456-7890");
        user.put("address", "123 Main St");

        System.out.println(user.get("name"));
        System.out.println(user.get("email"));
        System.out.println(user.get("phone"));
        System.out.println(user.get("address"));
    }
}
