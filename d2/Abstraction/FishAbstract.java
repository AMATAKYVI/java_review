package d2.Abstraction;

public abstract class FishAbstract extends AnimalAbstract {

    public FishAbstract(double weight) {
        super(weight);
    }

    public abstract void swim();

    @Override
    public void breathe() {
        System.out.println("Fish is breathing");
    }

    @Override
    public void eat() {
        System.out.println("Fish is eating seaweed");
    }

    @Override
    public void sleep() {
        System.out.println("Fish is sleeping in water");
    }

}
