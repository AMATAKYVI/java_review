package d18.ThreadExtra;

import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadExp {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Hello, Database Experiment!");

        // Object lock1 = new Object();
        // Object lock2 = new Object();
        // deadlock example
        // Thread t1 = new Thread(() -> {
        //     synchronized (lock1) {
        //         System.out.println("Thread 1: Holding lock 1...");
        //         try {
        //             Thread.sleep(100);
        //         } catch (InterruptedException e) {
        //         }
        //         System.out.println("Thread 1: Waiting for lock 2...");
        //         synchronized (lock2) {
        //             System.out.println("Thread 1: Holding lock 1 and lock 2...");
        //         }
        //     }
        // });
        // Thread t2 = new Thread(() -> {
        //     synchronized (lock2) {
        //         System.out.println("Thread 2: Holding lock 2...");
        //         try {
        //             Thread.sleep(100);
        //         } catch (InterruptedException e) {
        //         }
        //         System.out.println("Thread 2: Waiting for lock 1...");
        //         synchronized (lock1) {
        //             System.out.println("Thread 2: Holding lock 2 and lock 1...");
        //         }
        //     }
        // });
        // t1.start();
        // t2.start();
        // prevent deadlock by acquiring locks in a consistent order
        // Thread t1 = new Thread(() -> {
        //     synchronized (lock1) {
        //         System.out.println("Thread 1: Holding lock 1...");
        //         try {
        //             Thread.sleep(100);
        //         } catch (InterruptedException e) {
        //         }
        //         System.out.println("Thread 1: Waiting for lock 2...");
        //         synchronized (lock2) {
        //             System.out.println("Thread 1: Holding lock 1 and lock 2...");
        //         }
        //     }
        // });
        // Thread t2 = new Thread(() -> {
        //     synchronized (lock2) {
        //         System.out.println("Thread 2: Holding lock 2...");
        //         try {
        //             Thread.sleep(100);
        //         } catch (InterruptedException e) {
        //         }
        //         System.out.println("Thread 2: Waiting for lock 1...");
        //         synchronized (lock1) {
        //             System.out.println("Thread 2: Holding lock 2 and lock 1...");
        //         }
        //     }
        // });
        // ReentrantLock lock1 = new ReentrantLock();
        // ReentrantLock lock2 = new ReentrantLock();
        // Thread t1 = new Thread(() -> {
        //     while (true) {
        //         lock1.lock();
        //         try {
        //             System.out.println("Thread 1: Holding lock 1...");
        //             if (lock2.tryLock()) {
        //                 try {
        //                     System.out.println("Thread 1: Holding lock 1 and lock 2...");
        //                     break;
        //                 } finally {
        //                     lock2.unlock();
        //                 }
        //             }
        //         } finally {
        //             lock1.unlock();
        //         }
        //     }
        // });
        // Thread t2 = new Thread(() -> {
        //     while (true) {
        //         lock2.lock();
        //         try {
        //             System.out.println("Thread 2: Holding lock 2...");
        //             if (lock1.tryLock()) {
        //                 try {
        //                     System.out.println("Thread 2: Holding lock 1 and lock 2...");
        //                     break;
        //                 } finally {
        //                     lock1.unlock();
        //                 }
        //             }
        //         } finally {
        //             lock2.unlock();
        //         }
        //     }
        // });
        // t1.start();
        // t2.start();
        // try {
        //     Thread.sleep(5000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        // // starvation example
        // Thread t3 = new Thread(() -> {
        //     while (true) {
        //         lock1.lock();
        //         try {
        //             System.out.println("Thread 3: Holding lock 1...");
        //             try {
        //                 Thread.sleep(100);
        //             } catch (InterruptedException e) {
        //             }
        //         } finally {
        //             lock1.unlock();
        //         }
        //     }
        // });
        // t3.start(); 
        // Lock lock = new ReentrantLock();
        // Callable<Void> thread = () -> {
        //     String threadName = Thread.currentThread().getName();
        //     int threadNo = Integer.parseInt(threadName.substring(threadName.length() - 1));
        //     lock.lock();
        //     try {
        //         while (true) {
        //             System.out.println(threadName + " is doing work...");
        //             try {
        //                 Thread.sleep(100);
        //             } catch (InterruptedException e) {
        //             }
        //         }
        //     } finally {
        //         lock.unlock();
        //     }
        // };
        // var executor = java.util.concurrent.Executors.newFixedThreadPool(3);
        // try {
        //     var futures = executor.invokeAll(java.util.List.of(thread, thread, thread));
        // } catch (InterruptedException e) {
        //     throw new RuntimeException(e);
        // }
        // executor.shutdownNow();
        //atomic variable
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        Thread t4 = new Thread(() -> {
            while (!atomicBoolean.get()) {
                System.out.println("Thread 4: Waiting for atomic boolean to become true...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
            System.out.println("Thread 4: Atomic boolean is true, proceeding...");
        });
        t4.start();
        Thread t5 = new Thread(() -> {
            atomicBoolean.set(true);
            System.out.println("Thread 5: Setting atomic boolean to true...");
        });
        t5.start();
    }

}
