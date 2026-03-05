package d15.thread;

public class CustomThread extends Thread {

    public static void main(String[] args) {
        // var thread = new Thread(() -> {
        //     System.out.println("Hello from the thread!");
        // });
        // thread.start();
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            System.out.print(" 1 ");

            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        System.out.println("Hello from the thread!");
    }
}
