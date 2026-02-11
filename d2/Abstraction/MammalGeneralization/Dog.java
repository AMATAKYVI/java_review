package d2.Abstraction.MammalGeneralization;

import d2.Abstraction.MammalAbstract;

public class Dog extends MammalAbstract {

    private String type;
    private String name;

    public Dog(double weight) {
        super(weight);
        this.type = "Unknown";
        this.name = "Dog";
    }

    public Dog(double weight, String name, String type) {
        super(weight);
        this.type = type;
        this.name = name;
    }

    @Override
    public void eat() {
        System.out.println(name + " " + type + " is eating");
    }

    @Override
    public void sleep() {
        System.out.println(name + " " + type + " Dog is sleeping");
    }

    @Override
    public void walk() {
        System.out.println(name + " " + type + " Dog is walking");
    }

    @Override
    public void run() {
        System.out.println(name + " " + type + " Dog is running");
    }

    @Override
    public void breathe() {
        System.out.println(name + " " + type + " Dog is breathing");
    }
}
