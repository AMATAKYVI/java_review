package d2.Abstraction;

import d2.Abstraction.MammalGeneralization.Dog;
import d2.Abstraction.MammalGeneralization.KanikoFish;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog(25.0);
        // dog.eat();
        // dog.sleep();
        // dog.walk();
        // dog.run();

        // dog.breathe();
        ArrayList<AnimalAbstract> animals = new ArrayList<>();
        animals.add(new Dog(2.5, "Buddy", "Golden Retriever"));
        animals.add(new Dog(3.0, "Max", "German Shepherd"));
        animals.add(new KanikoFish(23, "Orange"));

        for (AnimalAbstract animal : animals) {
            animal.breathe();
            animal.eat();
            animal.sleep();
        }

        // procu
    }
}
