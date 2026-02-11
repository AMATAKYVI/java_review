package d1;

public class IntRange {

    public static void main(String[] args) {

        int maxValue = Integer.MAX_VALUE;
        int minValue = Integer.MIN_VALUE;

        long minLong = Long.MIN_VALUE;
        long maxLong = Long.MAX_VALUE;

        System.out.println("Maximum long value: " + maxLong);
        System.out.println("Minimum long value: " + minLong);

        System.out.println("Maximum value: " + maxValue);
        System.out.println("Minimum value: " + minValue);

        //ooverflow example
        int overflow = maxValue + 1;
        System.out.println("Overflow example: " + overflow);

        //underflow example
        int underflow = minValue - 1;
        System.out.println("Underflow example: " + underflow);
    }
}
