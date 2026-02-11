package d2.Abstraction;

public abstract class AnimalAbstract {

    private double weight;

    protected String type;

    public AnimalAbstract(double weight) {
        this.weight = weight;
    }

    public abstract void eat();

    public abstract void sleep();

    public void breathe() {
        System.out.println(this.getClass().getSimpleName() + " is breathing");
    }
}
