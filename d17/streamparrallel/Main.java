package d17.streamparrallel;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        int numberLength = 100_000;
        long[] numbers = new Random().longs(numberLength, 1, numberLength).toArray();

        long delta = 0;
        long iterations = 100;
        for (int i = 0; i < iterations; i++) {
            long start = System.nanoTime();
            double averageSerial = Arrays.stream(numbers).average().orElseThrow();
            long elapsedSerial = System.nanoTime() - start;

            start = System.nanoTime();
            double averageParallel = Arrays.stream(numbers).parallel().average().orElseThrow();
            long elapsedParallel = System.nanoTime() - start;
            delta += (elapsedSerial - elapsedParallel);
        }

        System.out.println("Delta (serial - parallel) = %d ms".formatted(delta / (iterations * 1_000_000)));
        //System.out.println("Average elapsed time (serial) = %d ms".formatted(delta /
        // long start = System.nanoTime();
        // double averageSerial = Arrays.stream(numbers).average().orElseThrow();
        // long elapsedSerial = System.nanoTime() - start;
        // System.out.println("Ave = %.2f, elapsed = %d ms (serial)".formatted(averageSerial, elapsedSerial / 1_000_000));

        // start = System.nanoTime();
        // double averageParallel = Arrays.stream(numbers).parallel().average().orElseThrow();
        // long elapsedParallel = System.nanoTime() - start;
        // System.out.println("Ave = %.2f, elapsed = %d ms (parallel)".formatted(averageParallel, elapsedParallel / 1_000_000));
        //10 persons
        Stream.generate(Person::new).limit(10).parallel()
                // .sorted(Comparator.comparing(Person::lastName))
                .forEachOrdered(System.out::println);

        System.out.println("------");

        Stream.generate(Person::new).limit(10).parallel()
                .sorted((p1, p2) -> p1.lastName().compareTo(p2.lastName()))
                .forEachOrdered(System.out::println);

        int sum = IntStream.range(1, 101).parallel().reduce(0, Integer::sum);
        System.out.println("Sum = " + sum);

        String humptyRyhtm = """
Humpty Dumpty sat on a wall,
Humpty Dumpty had a great fall.
All the king's horses and all the king's men
Couldn't put Humpty together again.
Jack and Jill went up the hill
To fetch a pail of water.     """;

        System.out.println("-------");

        var words = new Scanner(humptyRyhtm).tokens().toList();
        words.parallelStream().forEach(System.out::println);

        var backtogether = words.parallelStream().collect(Collectors.joining(" "));

        System.out.println(backtogether);

        Map<String, Long> lastNameCounts = Stream.generate(Person::new).limit(1000).parallel()
                .collect(Collectors.groupingByConcurrent(Person::lastName, Collectors.counting()));

        System.out.println(lastNameCounts);

        var lastCounts = Stream.generate(Person::new).limit(10000).parallel()
                .collect(Collectors.groupingByConcurrent(Person::lastName, Collectors.summingLong(person -> 1L)));
        System.out.println(lastCounts);

    }
}

record Person(String firstName, String lastName, int age) {

    private final static String[] firsts = {"Wohn", "Aane", "Alice", "Bob"};
    private final static String[] lasts = {"Smith", "Doe", "Johnson", "Brown"};
    private final static Random random = new Random();

    public Person() {
        this(
                firsts[random.nextInt(firsts.length)],
                lasts[random.nextInt(lasts.length)],
                random.nextInt(18, 80)
        );
    }

    @Override
    public final String toString() {
        return "%s %s, age %d".formatted(firstName, lastName, age);
    }
}
