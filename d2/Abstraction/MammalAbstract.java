package d2.Abstraction;

public abstract class MammalAbstract extends AnimalAbstract {

    public MammalAbstract(double weight) {
        super(weight);
    }

    public abstract void walk();

    public abstract void run();

    @Override
    public void breathe() {
        System.out.println("Mammal is breathing");
    }

    @Override
    public void eat() {
        System.out.println("Mammal is eating grass");
    }

    @Override
    public void sleep() {
        System.out.println("Mammal is sleeping in a den");
    }
}
