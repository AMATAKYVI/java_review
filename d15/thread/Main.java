package d15.thread;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        var currentThread = Thread.currentThread();

        printThreadInfo(currentThread);

        CustomThread customThread = new CustomThread();
        customThread.start();

        // for (int i = 0; i < 10; i++) {
        //     System.out.println(" 2 ");
        //     try {
        //         TimeUnit.SECONDS.sleep(1);
        //     } catch (Exception e) {
        //         e.printStackTrace();
        //     }
        // }
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.print(" 3 ");

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

    }

    private static void printThreadInfo(Thread thread) {

        System.out.println("Thread ID: " + thread.getId());
        System.out.println("Current thread: " + thread.getName());
        System.out.println("Priority: " + thread.getPriority());
        System.out.println("State: " + thread.getState());
        System.out.println("Thread group: " + thread.getThreadGroup());
        System.out.println("Is alive: " + thread.isAlive());
        // System.out.println("Is daemon: " + thread.isDaemon());
    }
}
