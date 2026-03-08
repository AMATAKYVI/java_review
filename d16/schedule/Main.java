package d16.schedule;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        // var dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.LONG);
        // Callable<ZonedDateTime> waitThenDoIt = () -> {
        //     ZonedDateTime zdt = null;
        //     try {
        //         TimeUnit.SECONDS.sleep(2);
        //         zdt = ZonedDateTime.now();
        //     } catch (InterruptedException e) {
        //         throw new RuntimeException(e);
        //     }
        //     return zdt;
        // };
        // var threadPool = Executors.newFixedThreadPool(4);
        // List<Callable<ZonedDateTime>> tasks = Collections.nCopies(4, waitThenDoIt);
        // try {
        //     System.out.println("-->" + ZonedDateTime.now().format(dtf));
        //     List<Future<ZonedDateTime>> results = threadPool.invokeAll(tasks);
        //     for (Future<ZonedDateTime> result : results) {
        //         try {
        //             System.out.println(result.get(1, TimeUnit.SECONDS).format(dtf));
        //         } catch (InterruptedException | ExecutionException | TimeoutException e) {
        //             throw new RuntimeException(e);
        //         }
        //     }
        // } catch (InterruptedException e) {
        //     throw new RuntimeException(e);
        // } finally {
        //     threadPool.shutdown();
        // }
        // System.out.println("-->" + ZonedDateTime.now().format(dtf));
        // ScheduledExecutorService executor = Executors.newScheduledThreadPool(4);
        // for (int i = 0; i < 4; i++) {
        //     executor.schedule(() -> {
        //         System.out.println("Scheduled task executed at: " + ZonedDateTime.now().format(dtf));
        //     }, 2 * (i + 1), TimeUnit.SECONDS);
        // }
        // executor.shutdown();
        int numberLength = 100_000;
        long[] numbers = new Random().longs(numberLength, 1, numberLength).toArray();
        long sum = Arrays.stream(numbers).sum();
        System.out.println("Sum: " + sum);

        ExecutorService threadPool = Executors.newWorkStealingPool(4);

    }
}
