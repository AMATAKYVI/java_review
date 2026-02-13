package d5.LambdaExp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Example {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(
                List.of("alpha", "beta", "gamma")
        );

        // list.forEach((s) -> System.out.println(Character.toUpperCase(s.charAt(0)) + "" + s.substring(1)));
        // int result = Calculator((a, b) -> a + b, 23, 24);
        String name = "Amatak";

        Consumer<String> consumer = (s) -> {
            String[] parts = s.split("");

            for (String part : parts) {
                System.out.println(part);
            }
        };

        // consumer.accept(name);
        Function<String, String> everySecondCharTwo = (String source) -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };

        // System.out.println(everySecondCharTwo.apply(name));
        String loveJava = "I love Java";

        Function<String, String> converter = (String source) -> {

            String[] parts = source.split(" ");

            for (int i = 0; i < parts.length; i++) {
                parts[i] = (parts[i].charAt(0)) + "" + parts[i].substring(1);
            }

            return String.join("", parts);
        };

        System.out.println(converter.apply(loveJava));

    }

    public static <T> T Calculator(Operation<T> operation, T x, T y) {
        System.out.println("Operation: " + operation.operate(x, y));
        return operation.operate(x, y);
    }

    public static String everySecondChar(String source) {
        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (i % 2 == 1) {
                returnVal.append(source.charAt(i));
            }
        }
        return returnVal.toString();
    }

}
