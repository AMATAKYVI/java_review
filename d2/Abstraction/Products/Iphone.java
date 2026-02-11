package d2.Abstraction.Products;

import d2.Abstraction.ProductForSale;

public class Iphone extends ProductForSale {

    private String model;
    private String name;

    public Iphone(String description, double price, String model, String name) {
        super("Phone", price, description);
        this.model = model;
        this.name = name;
    }

    @Override
    public void showDetails() {
        System.out.println("Iphone Model: " + model);
    }

    public String getName() {
        return name;
    }
}
