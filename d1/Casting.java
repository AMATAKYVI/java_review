package d1;

public class Casting {

    public static void main(String[] args) {
        // Casting
        int integer = 10;
        double doubleValue = integer;
        System.out.println("Integer: " + integer);
        System.out.println("Double: " + doubleValue);

        byte byteValue = (byte) integer;
        System.out.println("Byte: " + byteValue);
        char charValue = (char) integer;
        System.out.println("Character: " + charValue);
        long longValue = integer;
        System.out.println("Long: " + longValue);
        short shortValue = (short) integer;
        System.out.println("Short: " + shortValue);
    }
}
