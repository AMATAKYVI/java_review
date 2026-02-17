package d6.StoreChallenge.Primary;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Cart {

    enum CartType {
        PHYSICAL, VIRTUAL;
    };

    private static int lastId = 1;
    private int id;
    private LocalDate cartDate;
    private CartType type;
    private Map<String, Integer> products;

    public Cart(CartType type, int days) {
        this.type = type;
        id = lastId++;
        cartDate = LocalDate.now().minusDays(days);
        products = new HashMap<>();
    }

    public Cart(int id) {
        this.id = id;
    }

    public LocalDate getCartDate() {
        return cartDate;
    }

    public void addItem(InventoryItem item, int qty) {
        products.merge(item.getProduct().sku(), qty, Integer::sum);

        if (!item.reserveItem(qty)) {
            System.out.println("Out of stock");
        }
    }

    public void removeItem(InventoryItem item, int qty) {

        int current = products.get(item.getProduct().sku());

        if (current <= qty) {
            qty = current;
            products.remove(item.getProduct().sku());
            System.out.println("Item removed" + " " + item.getProduct().name());
        } else {
            products.merge(item.getProduct().sku(), qty, (old, newVal) -> old - newVal);
            System.out.println("Item removed" + " " + item.getProduct().name());
        }

        item.releaseItem(qty);
    }

    public void printSalesSlip(Map<String, InventoryItem> inventoryItems) {
        {
            double total = 0;
            System.out.println("----");
            System.out.println("Thank you for your sale:");
            for (var cartItem : products.entrySet()) {
                String key = cartItem.getKey();
                int value = cartItem.getValue();
                System.out.println(key + " " + value);
                total += inventoryItems.get(key).getPrice() * value;
            }
            System.out.println("Total: " + total);
            System.out.println("----");
            System.out.println("Sales Slip:");
            System.out.println("Id: " + id);
            System.out.println("Date: " + cartDate);
            System.out.println("Type: " + type);
            System.out.println("Products:");
            for (var cartItem : products.entrySet()) {
                String key = cartItem.getKey();
                int value = cartItem.getValue();
                System.out.println(key + ": " + value);
            }
        }
    }

    public Map<String, Integer> getProducts() {
        return products;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Cart{"
                + "id=" + id
                + "cartDate=" + cartDate
                + ", type=" + type
                + ", products=" + products
                + '}';
    }

}
