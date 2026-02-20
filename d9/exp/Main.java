package d9.exp;

import java.util.stream.IntStream;
import java.util.stream.Stream;

record Seat(char row, int number, double price) {

    public Seat(char row, int number) {
        this(row, number,
                row == 'A' || row == 'E' || row == 'I' || row == 'O' || row == 'U' ? 20 : 10
        );
    }

    @Override
    public final String toString() {
        return "Seat{"
                + "row=" + row
                + ", number=" + number
                + ", price=" + price
                + '}';
    }
}

public class Main {

    public static void main(String[] args) {

        int max = 100;
        int seatInRow = 10;
        var stream = Stream.iterate(0, i -> i < max, i -> i + 1).map(i -> new Seat((char) ('A' + i / seatInRow), i % seatInRow + 1)).mapToDouble(Seat::price);
        // stream.forEach(System.out::println);

        var result = IntStream.iterate(0, i -> i <= 1000, i -> i + 2).summaryStatistics();

        System.out.println(result);
    }
}
