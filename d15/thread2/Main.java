package d15.thread2;

public class Main {

    public static void main(String[] args) {
        // System.out.println("Hello world!");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread thread = new Thread(() -> {
            System.out.println("Hello world!");
            for (int i = 0; i < 10; i++) {
                System.out.println(".");

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Interupted!");
                    return;
                }
            }
            System.out.println("complete!");
        });
        System.out.println("Starting thread..." + thread.getName());
        thread.start();
        // System.out.println("Hello world!");

        long now = System.currentTimeMillis();
        while (thread.isAlive()) {
            // if (System.currentTimeMillis() - now > 2000) {
            //     System.out.println("Interrupting thread...");
            //     thread.interrupt();
            //     break;
            // }
            System.out.println("Busy waiting...");

            try {
                Thread.sleep(1000);
                System.out.println("second state");

                if (System.currentTimeMillis() - now > 2000) {
                    System.out.println("Interrupting thread...");
                    thread.interrupt();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread installThread = new Thread(() -> {
                System.out.println("Installing...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Installed!");
            });
            installThread.start();
            thread.join();
        }
    }
}
