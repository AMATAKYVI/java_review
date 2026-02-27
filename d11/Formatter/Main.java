package d11.Formatter;

import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        String helloWorld3 = Main.format("%s %s", "Hello", "World");
        System.out.println(helloWorld3);

        Scanner scanner = new Scanner("Hello, World! 123 456");
        Stream<String> iterator = scanner.tokens();

        iterator.forEach(s -> System.out.println(s));

        System.out.println("----");

        String sentence = "Hello, World!";
        boolean matches = sentence.matches("Hello, World!");
        System.out.println("we found match " + matches);

        String chellenge2 = "[A-Z][\\p{all}]+[.?!]$";
        int count = 0;
        for (String s : List.of("The bike is red, and has flat tires.", "I am being a new L.P.A student!", "Hello, friends and family: Welcome!", "How are you?")) {

            boolean matches2 = s.matches(chellenge2);
            System.out.println("we found match " + matches2 + count++ + " " + s);
        }

        System.out.println("----");

        String sentence3 = "I like motorcycles.";
        boolean matches3 = Pattern.matches("[A-Z].*[.]", sentence3);
        System.out.println(matches3);

        Pattern firstPattern = Pattern.compile("[A-Z].*[.]", Pattern.CASE_INSENSITIVE);
        boolean matches4 = firstPattern.matcher(sentence3).matches();
        System.out.println(matches4);

        System.out.println("----");
        System.out.println(firstPattern.pattern());
        // System.out.println(firstPattern.lookingAt());

        String phoneList = """
                800-213-1234
                800-657-4523
                800-752-9645
                800-123-4567
                (800) 233-6533
                (800)657-4523
                800-930-2302

                """;
        Pattern phonePattern = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
        Stream<MatchResult> phoneStream = phonePattern.matcher(phoneList).results();

        phoneStream.forEach(mr -> System.out.println(mr.group()));

        String htmlSnippet = """
                
                <html>
                    <body>
                        <h1>Heading</h1>
                        <p>Paragraph 1</p>
                        <p>Paragraph 2</p>
                    </body>
                </html>
                """;
        Pattern htmlPattern = Pattern.compile("<h1>.*</h1>");
        Stream<MatchResult> htmlStream = htmlPattern.matcher(htmlSnippet).results();
        htmlStream.forEach(mr -> System.out.println(mr.group()));

        String emailText = """
                john.boy@gmail.com
                jane.doe@me.com
                jdoe@me.com
                bob-23@gmail.com
                david@invalid.com
                """;
        Pattern partialPattern = Pattern.compile("(.+)@(.+)");
        Stream<MatchResult> emailStream = partialPattern.matcher(emailText).results();
        emailStream.forEach(mr -> System.out.println(mr.group()));

        String[] emailSamples = emailText.split("\n");
        for (String emailSample : emailSamples) {
            String[] emailParts = emailSample.split("@");
            System.out.println(emailParts[0]);
            System.out.println(emailParts[1]);
        }
    }

    private static String format(String regexp, String... args) {
        int index = 0;

        while (regexp.contains("%s")) {
            regexp = regexp.replaceFirst("%s", args[index++]);
        }
        return regexp;
    }
}
