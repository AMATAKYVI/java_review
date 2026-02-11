package d2.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

record GroceryItem(String name, double price) {

    public GroceryItem(String name, double price) {

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}

public class ListInterface {

    public static void main(String[] args) {
        List<GroceryItem> diaryList = new ArrayList<>();
        GroceryItem item1 = new GroceryItem("Milk", 2.99);
        GroceryItem item2 = new GroceryItem("Butter", 1.49);
        GroceryItem item3 = new GroceryItem("Eggs", 3.49);

        diaryList.add(item1);
        diaryList.add(item2);
        diaryList.add(item3);

        // remove grocery with name Milk out of list
        diaryList.removeIf(item -> item.name().equals("Milk"));
        System.out.println("Milk has been removed from the list.");
        diaryList.add(new GroceryItem("Cheese", 4.99));

        // get current time and print it in format of hour:minute:second and date in format of year-month-day
        java.time.LocalDateTime now = java.time.LocalDateTime.now();
        java.time.format.DateTimeFormatter timeFormatter = java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss");
        java.time.format.DateTimeFormatter dateFormatter = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("Current time: " + now.format(timeFormatter));
        System.out.println("Current date: " + now.format(dateFormatter));
        System.out.println("Cheese has been added to the list. At " + now.format(timeFormatter) + " on " + now.format(dateFormatter));

        for (GroceryItem item : diaryList) {
            System.out.println(item);
        }
        String[] items = {"Apples", "Bananas", "Oranges", "Watermelon"};
        List<String> itemList = List.of(items);
        System.out.println("Item List: " + itemList);
        System.out.println(itemList.getClass().getName());
        //itemList.add("Grapes"); // this will throw an UnsupportedOperationException because List.of() returns an immutable list

        ArrayList<String> mutableItemList = new ArrayList<>(itemList);
        mutableItemList.add("Grapes");
        System.out.println("Mutable Item List: " + mutableItemList);
        System.out.println(Arrays.toString(items));
        ArrayList<String> stringLists = new ArrayList<>(List.of("Bread", "Butter", "Jam"));
        String[] stringArray = stringLists.toArray(new String[0]);
        System.out.println("String Array: " + Arrays.toString(stringArray));
    }

}
