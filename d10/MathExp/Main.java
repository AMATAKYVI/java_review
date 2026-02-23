package d10.MathExp;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        System.out.println("hello");

        System.out.println(Integer.MAX_VALUE);
        int maxMinusFive = Integer.MAX_VALUE - 5;
        // System.out.println(maxMinusFive);

        // for (int j = 0, id = maxMinusFive; j < 10;
        //         id = Math.incrementExact(id), j++) {
        //     System.out.printf("Assigning id %, d%n", id);
        // }
        System.out.println(Math.abs(-50));
        System.out.println(Integer.MIN_VALUE);
        // System.out.println(Math.abs(Integer.MIN_VALUE));\
        System.out.println(Math.abs((long) Integer.MIN_VALUE));

        //Math random
        int random = (int) (Math.random() * 100);
        System.out.println(random);

        //random 10 numbers
        for (int i = 0; i < 10; i++) {
            System.out.println((int) (Math.random() * 100));
        }
        int[] randomValues = IntStream.generate(() -> (int) (Math.random() * 100)).limit(10).toArray();
        System.out.println(Arrays.toString(randomValues));
    }
}
