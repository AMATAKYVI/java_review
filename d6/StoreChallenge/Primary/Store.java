package d6.StoreChallenge.Primary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Random;
import java.util.TreeMap;
import java.util.TreeSet;

public class Store {

    private static Random random = new Random();
    private Map<String, InventoryItem> inventory = new HashMap<>();
    private static NavigableSet<Cart> carts = new TreeSet<>(Comparator.comparing(Cart::getId));

    private Map<Category, Map<String, InventoryItem>> aisleInventory;

    public static void main(String[] args) {

        Store myStore = new Store();
        myStore.stockStore();
        myStore.listInventory();

        System.out.println("-----------------");
        myStore.stockAisles();
        myStore.listProductsByCategory(false, true);

        System.out.println("-----------------");
        myStore.manageStoreCarts();

        System.out.println("-----------------");
        myStore.listProductsByCategory(true, true);

        System.out.println("-----------------");
        myStore.checkOutCart(carts.first());
        myStore.abandonCarts();

    }

    private void manageStoreCarts() {
        Cart cart1 = new Cart(Cart.CartType.PHYSICAL, 1);
        carts.add(cart1);

        InventoryItem item = aisleInventory.get(Category.BEVERAGE).get("sku1");
        cart1.addItem(item, 6);
        System.out.println(cart1);

        Cart cart2 = new Cart(Cart.CartType.VIRTUAL, 1);

        cart2.addItem(aisleInventory.get(Category.BEVERAGE).get("sku1"), 6);

    }

    private boolean checkOutCart(Cart cart) {

        for (var cartItem : cart.getProducts().entrySet()) {
            var item = inventory.get(cartItem.getKey());
            var qty = cartItem.getValue();
            if (!item.sellItem(qty)) {
                return false;
            }

        }

        cart.printSalesSlip(inventory);
        carts.remove(cart);
        return true;
    }

    private void abandonCarts() {

    }

    private void listProductsByCategory(boolean includeHeader, boolean includeDetail) {
        aisleInventory.keySet().forEach(k -> {

            if (includeHeader) {
                System.out.println("------\n" + k + "\n------");
            }
            if (!includeDetail) {
                aisleInventory.get(k).keySet().forEach(System.out::println);
            } else {
                aisleInventory.get(k).values().forEach(System.out::println);
            }

        });
    }

    private void stockStore() {
        inventory = new HashMap<>();
        List<Product> products = new ArrayList<>(List.of(
                new Product("sku1", "product1", "manufacturer1", Category.BEVERAGE),
                new Product("sku2", "product2", "manufacturer2", Category.DAIRY),
                new Product("sku3", "product3", "manufacturer3", Category.BEVERAGE),
                new Product("sku4", "product4", "manufacturer4", Category.MEAT),
                new Product("sku5", "product5", "manufacturer5", Category.PRODUCE),
                new Product("sku6", "product6", "manufacturer6", Category.CEREAL),
                new Product("sku7", "product7", "manufacturer7", Category.BEVERAGE),
                new Product("sku8", "product8", "manufacturer8", Category.DAIRY),
                new Product("sku9", "product9", "manufacturer9", Category.BEVERAGE),
                new Product("sku10", "product10", "manufacturer10", Category.MEAT)
        ));

        products.forEach(p -> inventory.put(p.sku(), new InventoryItem(p, random.nextDouble(0, 1.25), 1000, 5)));
    }

    private void stockAisles() {
        aisleInventory = new EnumMap<>(Category.class);
        for (InventoryItem item : inventory.values()) {
            Category aisle = item.getProduct().category();
            Map<String, InventoryItem> productMap = aisleInventory.get(aisle);
            if (productMap == null) {
                productMap = new TreeMap<>();
            }
            productMap.put(item.getProduct().sku(), item);
            aisleInventory.put(aisle, productMap);
        }
    }

    private void listInventory() {

        System.out.println("------");

        inventory.values().forEach(System.out::println);
    }

}
