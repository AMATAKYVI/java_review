package d1;

public class Expressions {

    public static void main(String[] args) {
        // Arithmetic Operators
        int a = 10;
        int b = 3;
        int result = a + b;
        System.out.println("Addition: " + result);
        result = a - b;
        System.out.println("Subtraction: " + result);
        result = a * b;
        System.out.println("Multiplication: " + result);
        result = a / b;
        System.out.println("Division: " + result);
        result = a % b;
        System.out.println("Modulus: " + result);

        // Relational Operators
        boolean isEqual = a == b;
        System.out.println("Equality: " + isEqual);
        boolean isNotEqual = a != b;
        System.out.println("Inequality: " + isNotEqual);
        boolean isGreaterThan = a > b;
        System.out.println("Greater than: " + isGreaterThan);
        boolean isLessThan = a < b;
        System.out.println("Less than: " + isLessThan);
        boolean isGreaterThanOrEqual = a >= b;
        System.out.println("Greater than or equal: " + isGreaterThanOrEqual);
        boolean isLessThanOrEqual = a <= b;
        System.out.println("Less than or equal: " + isLessThanOrEqual);

        // Logical Operators
        boolean isAnd = a > 0 && b > 0;
        System.out.println("Logical AND: " + isAnd);
        boolean isOr = a > 0 || b > 0;
        System.out.println("Logical OR: " + isOr);
        boolean isNot = !isAnd;
        System.out.println("Logical NOT: " + isNot);

        // Assignment Operators
        int x = 10;
        x += 5;
        System.out.println("Assignment Addition: " + x);
        x -= 3;
        System.out.println("Assignment Subtraction: " + x);
        x *= 2;
        System.out.println("Assignment Multiplication: " + x);
        x /= 4;
        System.out.println("Assignment Division: " + x);
        x %= 3;
        System.out.println("Assignment Modulus: " + x);

        // Increment and Decrement Operators
        int y = 10;
        y++;
        System.out.println("Increment: " + y);
        y--;
        System.out.println("Decrement: " + y);

        // Bitwise Operators
        int c = 10;
        int d = 3;
        int resultBitwiseAnd = c & d;
        System.out.println("Bitwise AND: " + resultBitwiseAnd);
        int resultBitwiseOr = c | d;
        System.out.println("Bitwise OR: " + resultBitwiseOr);
        int resultBitwiseXor = c ^ d;
        System.out.println("Bitwise XOR: " + resultBitwiseXor);
        int resultBitwiseNot = ~c;
        System.out.println("Bitwise NOT: " + resultBitwiseNot);
        int resultLeftShift = c << 2;
        System.out.println("Left Shift: " + resultLeftShift);
        int resultRightShift = c >> 2;
        System.out.println("Right Shift: " + resultRightShift);
        int resultUnsignedRightShift = c >>> 2;
        System.out.println("Unsigned Right Shift: " + resultUnsignedRightShift);

        // Ternary Operator
        int age = 18;
        String message = age >= 18 ? "You can vote" : "You cannot vote";
        System.out.println(message);

        // Conditional Operator
        int score = 85;
        String grade = score >= 90 ? "A" : score >= 80 ? "B" : score >= 70 ? "C" : "D";
        System.out.println("Grade: " + grade);

        // Null Coalescing Operator
        String name = null;
        String defaultName = "John";
        String displayName = name != null ? name : defaultName;
        System.out.println("Display Name: " + displayName);

        // Range Operator
        int number = 5;
        boolean isInRange = number >= 1 && number <= 10;
        System.out.println("Is in range: " + isInRange);

        // Switch Case
        int day = 3;
        String dayOfWeek;
        switch (day) {
            case 1:
                dayOfWeek = "Monday";
                break;
            case 2:
                dayOfWeek = "Tuesday";
                break;
            case 3:
                dayOfWeek = "Wednesday";
                break;
            default:
                dayOfWeek = "Invalid day";
        }
        System.out.println("Day of the week: " + dayOfWeek);

        // String Concatenation
        String firstName = "John";
        String lastName = "Doe";
        String fullName = firstName + " " + lastName;
        System.out.println("Full Name: " + fullName);

        // String Interpolation
        int age2 = 30;
        String message2 = "My name is John and I am " + age2 + " years old.";
        System.out.println(message2);
        // String Formatting
        double pi = 3.14159;
        String formattedPi = String.format("%.2f", pi);
        System.out.println("Formatted PI: " + formattedPi);

        // String Length
        String text = "Hello, World!";
        int length = text.length();
        System.out.println("Length: " + length);

        // String Substring
        String substring = text.substring(7);
        System.out.println("Substring: " + substring);

        // String Replace
        String replacedText = text.replace("World", "Universe");
        System.out.println("Replaced Text: " + replacedText);

        // String Split
        String[] words = text.split(", ");
        System.out.println("Words: " + words[0]);
        System.out.println("Words: " + words[1]);

        // String Trim
        String trimmedText = text.trim();
        System.out.println("Trimmed Text: " + trimmedText);

        // String To Upper and Lower Case
        String upperCaseText = text.toUpperCase();
        System.out.println("Upper Case Text: " + upperCaseText);
        String lowerCaseText = text.toLowerCase();
        System.out.println("Lower Case Text: " + lowerCaseText);

        // String Contains
        boolean containsWorld = text.contains("World");
        System.out.println("Contains 'World': " + containsWorld);

        // String StartsWith and EndsWith
        boolean startsWithHello = text.startsWith("Hello");
        System.out.println("Starts with 'Hello': " + startsWithHello);
        boolean endsWithWorld = text.endsWith("World");
        System.out.println("Ends with 'World': " + endsWithWorld);

        // String IndexOf
        int indexOfWorld = text.indexOf("World");
        System.out.println("Index of 'World': " + indexOfWorld);

        // String LastIndexOf
        int lastIndexOfWorld = text.lastIndexOf("World");
        System.out.println("Last index of 'World': " + lastIndexOfWorld);

        // String Concatenation
        String firstName111 = "John";
        String lastName111 = "Doe";
        String fullName111 = firstName111 + " " + lastName111;
        System.out.println("Full Name: " + fullName);

        // String Interpolation
        int age1 = 30;
        String message11 = "My name is John and I am " + age1 + " years old.";
        System.out.println(message11);
    }
}
