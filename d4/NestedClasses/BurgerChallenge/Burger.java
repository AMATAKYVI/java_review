package d4.NestedClasses.BurgerChallenge;

public class Burger {

    private String name;
    private int price;
    private boolean isVeg;
    private boolean isVegBun;

    public Burger(String name, int price, boolean isVeg, boolean isVegBun) {
        this.name = name;
        this.price = price;
        this.isVeg = isVeg;
        this.isVegBun = isVegBun;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public boolean isVeg() {
        return isVeg;
    }

    public boolean isVegBun() {
        return isVegBun;
    }

    @Override
    public String toString() {
        return "Burger{"
                + "name='" + name + '\''
                + ", price=" + price
                + ", isVeg=" + isVeg
                + ", isVegBun=" + isVegBun
                + '}';
    }

}
