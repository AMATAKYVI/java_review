package d1;

public class Decimal {

    public static void main(String[] args) {
        // Decimal numbers
        double doubleValue = 5.5;
        float floatValue = 3.14f;

        System.out.println("Double: " + doubleValue);
        System.out.println("Float: " + floatValue);

        //perform operations with decimal numbers
        double sum = doubleValue + floatValue;
        System.out.println("Sum: " + sum);
        double product = doubleValue * floatValue;
        System.out.println("Product: " + product);
    }
}
