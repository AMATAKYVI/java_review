package d1;

public class WrapperClass {

    public static void main(String[] args) {
        // Wrapper Class
        Integer integer = new Integer(10);
        System.out.println("Integer: " + integer);
        Double doubleValue = new Double(5.5);
        System.out.println("Double: " + doubleValue);
        Boolean booleanValue = new Boolean(true);
        System.out.println("Boolean: " + booleanValue);
        Character character = new Character('A');
        System.out.println("Character: " + character);

        //perform operations using wrapper classes
        int sum = integer + 5; // unboxing
        System.out.println("Sum: " + sum);
        double product = doubleValue * 2; // unboxing
        System.out.println("Product: " + product);
        boolean isTrue = booleanValue && false; // unboxing
        System.out.println("Logical AND: " + isTrue);
        char nextChar = (char) (character + 1); // unboxing and arithmetic operation
        System.out.println("Next character: " + nextChar);

    }
}
