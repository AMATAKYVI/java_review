package d17.streamparrallel;

import java.util.concurrent.ArrayBlockingQueue;

public class VisitorList {

    private static final ArrayBlockingQueue<Person> queue = new ArrayBlockingQueue<>(100);

    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            while (true) {
                try {
                    queue.put(new Person());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            while (true) {
                try {
                    Person person = queue.take();
                    System.out.println(person);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
