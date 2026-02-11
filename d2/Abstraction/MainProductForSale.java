package d2.Abstraction;

import d2.Abstraction.Products.Iphone;
import d2.Abstraction.Products.Keyboard;

public class MainProductForSale {

    public static void main(String[] args) {
        ProductForSale[] products = new ProductForSale[2];
        products[0] = new Iphone("A smartphone with advanced features", 999.99, "iPhone 13 Pro", "Apple");
        products[1] = new Keyboard(49.99, "A high-quality mechanical keyboard", "Logitech G Pro");

        for (ProductForSale product : products) {
            System.out.println("Product Name: " + product.getName());
            System.out.println("Price: $" + product.getPrice());
            System.out.println("Description: " + product.getDescription());
            product.showDetails();
            System.out.println();
        }
    }
}
