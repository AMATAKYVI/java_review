package d9.streamexp;

import java.util.Arrays;
import java.util.stream.Stream;

public class AnotherExp {

    public static void main(String[] args) {

        int seed = 1;
        var streamB = Stream.iterate(seed, i -> i <= 15, i -> i + 1).map(i -> "B" + i);

        streamB.forEach(System.out::println);

        int seed2 = 16;
        var streamG = Stream.iterate(seed2, i -> i <= 30, i -> i + 1).map(i -> "G" + i);

        streamG.forEach(System.out::println);

        String[] oLabels = new String[15];

        Arrays.setAll(oLabels, i -> "O" + (i + 1));

        Stream.of(oLabels).forEach(System.out::println);
    }
}
