package d2.List;

import java.util.LinkedList;

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

public class LinkedListExample {

    private Node head;

    public void add(GroceryItem item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    private static class Node {

        GroceryItem data;
        Node next;

        Node(GroceryItem data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        // This is just a placeholder for the LinkedList implementation
        System.out.println("LinkedList implementation will go here.");

        //simple linkedlist items
        GroceryItem item1 = new GroceryItem("Bread", 2.5);
        GroceryItem item2 = new GroceryItem("Milk", 1.5);
        GroceryItem item3 = new GroceryItem("Eggs", 3.0);
        GroceryItem item4 = new GroceryItem("Cheese", 4.5);
        GroceryItem item5 = new GroceryItem("Butter", 2.0);

        LinkedList<GroceryItem> shoppingList = new LinkedList<>();
        shoppingList.addFirst(new GroceryItem("Apples", 1.0));
        System.out.println("Shopping List:");
        System.out.println(shoppingList);
    }
}
