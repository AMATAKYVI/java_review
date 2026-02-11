package d2.Abstraction;

public abstract class BirdsAbstract extends AnimalAbstract {

    public BirdsAbstract(double weight) {
        super(weight);
    }

    public abstract void fly();

    public abstract void sing();

    @Override
    public void sleep() {
        System.out.println("Bird is sleeping on a tree");
    }

    @Override
    public void eat() {
        System.out.println("Bird is eating worms");
    }

}
