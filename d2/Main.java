package d2;

public class Main {

    public static void main(String[] args) {
        DogInheritAnimal dog = new DogInheritAnimal("Fido", 2, "Canine", "Outdoor", "Carnivore", "Bark", "Brown", "Golden Retriever", true);
        System.out.println("Dog Name: " + dog.getName());
        System.out.println("Dog Age: " + dog.getAge());
        System.out.println("Dog Species: " + dog.getSpecies());
        System.out.println("Dog Habitat: " + dog.getHabitat());
        System.out.println("Dog Diet: " + dog.getDiet());
        System.out.println("Dog Sound: " + dog.getSound());
        System.out.println("Dog Color: " + dog.getColor());
        System.out.println("Dog Breed: " + dog.getBreed());
        System.out.println("Is the dog trained? " + dog.isTrained());
    }
}
