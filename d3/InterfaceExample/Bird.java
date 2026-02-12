package d3.InterfaceExample;

public class Bird implements FlightEnabled, Eat {

    @Override
    public void fly() {
        System.out.println("The bird is flying.");
    }

    public void chirp() {
        System.out.println("Chirp chirp!");
    }

    @Override
    public void eat() {
        System.out.println("The bird is eating.");
    }
}
