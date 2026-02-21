package d10.MoreStream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        System.out.println("hi world");

        Character[] bingoWorld = {'B', 'I', 'N', 'G', 'O'};

        // B1-15
        var streamB = Stream.iterate(1, i -> i <= 15, i -> i + 1).map(i -> "B" + i);

        // G16-30
        var streamG = Stream.iterate(16, i -> i <= 30, i -> i + 1).map(i -> "G" + i);
        //N31-45
        var streamN = Stream.iterate(31, i -> i <= 45, i -> i + 1).map(i -> "N" + i);
        //I46-60
        var streamI = Stream.iterate(46, i -> i <= 60, i -> i + 1).map(i -> "I" + i);
        // Stream.of(bingoWorld).map(s -> {
        //     // System.err.println("" + s);
        //     return s;
        // }).forEach(System.out::println);

        var streamBG = Stream.concat(streamB, streamG);
        var streamBGI = Stream.concat(streamBG, streamI);
        var streamBGIN = Stream.concat(streamBGI, streamN);
        // streamBGIN.forEach(System.out::println);

        IntStream.iterate((int) 'A', i -> i <= (int) 'z', i -> i + 1).filter(Character::isAlphabetic).filter(i -> Character.toUpperCase(i)
                > 'E').forEach(s -> System.out.printf("%c ", s));

        var result = IntStream.iterate(0, i -> i <= 1000, i -> i + 2).summaryStatistics();
        System.out.println(result);
    }
}
