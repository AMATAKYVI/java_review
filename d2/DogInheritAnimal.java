package d2;

public class DogInheritAnimal extends Animal {

    private String breed;
    private boolean isTrained;

    public DogInheritAnimal(String name, int age, String species, String habitat, String diet, String sound, String color, String breed, boolean isTrained) {
        super(name, age, species, habitat, diet, sound, color);
        this.breed = breed;
        this.isTrained = isTrained;
    }

    public String getBreed() {
        return breed;
    }

    public boolean isTrained() {
        return isTrained;
    }
}
