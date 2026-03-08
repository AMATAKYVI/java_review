package d16.challenge;

import java.util.ArrayList;
import java.util.List;

public class ShoeWarehouse {

    private List<Order> shippingItems;
    public final static String[] PRODUCT_LIST = {"Running Shoes", "Sandals", "Boots", "Slippers", "High Tops"};

    public ShoeWarehouse() {
        this.shippingItems = new ArrayList<>();
    }

    public synchronized void receiveOrder(Order order) {

        while (shippingItems.size() > 20) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException("Thread interrupted while waiting to receive order.");
            }
        }
        shippingItems.add(order);
        System.out.println("Received order: " + ". Total orders in warehouse: " + shippingItems.size());
        notifyAll();
    }

    public synchronized Order fullfillOrder() {
        while (shippingItems.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException("Thread interrupted while waiting to fulfill order.");
            }
        }
        Order order = shippingItems.remove(0);
        System.out.println("Fulfilled order: " + ". Total orders in warehouse: " + shippingItems.size());
        notifyAll();
        return order;
    }
}
