package d6.StoreChallenge;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

record Product(String sku, String name, String manufacturer, String category) {

}

class Cart {

    private int Id;
    private Map<String, Integer> products = new HashMap<>();
    private LocalDate date;
    private String type;

    public void addItem(Product product) {
        products.put(product.sku(), 1);
    }

    public void removeItem(Product product) {
        products.remove(product.sku());
    }

    public void printSalesSlip() {
        System.out.println("Sales Slip:");
        System.out.println("Id: " + Id);
        System.out.println("Date: " + date);
        System.out.println("Type: " + type);
        System.out.println("Products:");
        for (Map.Entry<String, Integer> entry : products.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

class InventoryItem {

    private Product product;
    private int qtyTotal;
    private int qtyReserved;
    private int qtyReorder;
    private int qtyLow;
    private int salesPrice;

    public void reserveItem(int qtyToReserve) {
        this.qtyReserved += qtyToReserve;
    }

    public void releaseItem(int qtyToRelease) {
        this.qtyReserved -= qtyToRelease;
    }

    public void sellItem(int qtyToSell) {
        this.qtyTotal -= qtyToSell;
    }

    public void placeInventoryOrder(int qtyToOrder) {
        this.qtyReorder += qtyToOrder;
    }
}

public class Store {

    //what should i put as inventory
    private Map<String, Product> inventory = new HashMap<>();
    private Map<String, Integer> carts = new HashMap<>();
    private Map<String, Integer> aisleInventory = new HashMap<>();

    public Store() {
        // generate me inventory
        if (inventory.size() == 0) {
            for (int i = 0; i < 20; i++) {
                Product product = new Product("sku" + i, randomProductNameGenerator(), "manufacturer" + i, "category" + i);
                inventory.put(product.sku(), product);
            }
        }
    }

    public int randomPriceGenerator() {
        return (int) (Math.random() * 100);
    }

    public String randomProductNameGenerator() {
        String[] randomName = {"Milk", "Bread", "Coke", "Beer", "Frozen Pizza", "Ice Cream", "Cake", "Butter", "Orange Juice", "Candy", "Chocolate", "Parsley"};
        return randomName[(int) (Math.random() * randomName.length)];
    }

    @Override
    public String toString() {
        return "Store{"
                + "inventory=" + inventory
                + '}';
    }

}
