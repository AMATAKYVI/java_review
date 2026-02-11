package d2.Abstraction.MammalGeneralization;

import d2.Abstraction.FishAbstract;

public class KanikoFish extends FishAbstract {

    private String name;
    private String color;

    @Override
    public void eat() {
        System.out.println(name + " " + color + " is eating algae");
    }

    public KanikoFish(double weight, String color) {
        super(weight);
        this.name = "KanikoFish";
        this.color = color;
    }

    @Override
    public void swim() {
        System.out.println(name + " " + color + " is swimming");
    }
}
