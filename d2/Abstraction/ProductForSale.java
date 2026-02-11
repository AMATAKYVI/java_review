package d2.Abstraction;

record OrderItem(int quantity, ProductForSale product) {

    public double getTotalPrice() {
        return quantity * product.getSalePrice();
    }

    public String toString() {
        return quantity + " x " + product.printPricedItem();
    }

}

public abstract class ProductForSale {

    private String type;
    private double price;
    private String description;

    public ProductForSale(String type, double price, String description) {
        this.type = type;
        this.price = price;
        this.description = description;
    }

    public double getSalePrice() {
        return price;
    }

    public String printPricedItem() {
        return type + ": " + description + " - $" + price;
    }

    public String getName() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public abstract void showDetails();

}
