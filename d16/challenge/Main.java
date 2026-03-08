package d16.challenge;

import java.util.Random;

record Order(int orderId, String product, int quantity) {

}

public class Main {

    private static final Random random = new Random();

    public static void main(String[] args) {
        System.out.println("Hello world!");

        ShoeWarehouse shoeWarehouse = new ShoeWarehouse();
        Thread buyerThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shoeWarehouse.receiveOrder(new Order(random.nextInt(10000, 99999), ShoeWarehouse.PRODUCT_LIST[random.nextInt(0, 5)], random.nextInt(1, 4)));
            }
        });

        buyerThread.start();

        for (int i = 0; i < 2; i++) {

            Thread consumerThread = new Thread(() -> {

                for (int j = 0; j < 5; j++) {
                    Order item = shoeWarehouse.fullfillOrder();
                }
            });
            consumerThread.start();
        }

    }

}
