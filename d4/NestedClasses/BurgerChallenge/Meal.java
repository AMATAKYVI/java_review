package d4.NestedClasses.BurgerChallenge;

public class Meal {

    private double base = 0.5;
    private Item burger;
    private Item drink;
    private Item side;

    public Meal() {
        burger = new Burger("Burger", "Hamburger", 1.5);
        drink = new Item("Drink", "Coke", 0.5);
        side = new Item("Side", "Fries", 0.5);
    }

    private class Item {

        private String name;
        private String type;
        private double price;

        public Item(String name, String type, double price) {
            this.name = name;
            this.type = type;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Item{"
                    + "name='" + name + '\''
                    + ", type='" + type + '\''
                    + ", price=" + price
                    + '}';
        }

    }

    @Override
    public String toString() {
        return "Meal{"
                + "base=" + base
                + ", burger=" + burger
                + ", drink=" + drink
                + ", side=" + side
                + '}';
    }

    private class Burger extends Item {

        Burger(String name, String type, double price) {
            super(name, type, price);
        }
    }

}
