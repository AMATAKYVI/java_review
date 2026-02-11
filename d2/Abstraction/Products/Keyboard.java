package d2.Abstraction.Products;

import d2.Abstraction.ProductForSale;

public class Keyboard extends ProductForSale {

    private String name;

    public Keyboard(double price, String description, String name) {
        super("Keyboard", price, description);
        this.name = name;
    }

    @Override
    public void showDetails() {
        System.out.println("This is a high-quality keyboard.");
    }

    public String getName() {
        return this.name;
    }
}
