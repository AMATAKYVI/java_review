package d2;

public class Animal {

    private String name;
    private int age;
    private String species;
    private String habitat;
    private String diet;
    private String sound;
    private String color;

    public Animal(String name, int age, String species, String habitat, String diet, String sound, String color) {
        this.name = name;
        this.age = age;
        this.species = species;
        this.habitat = habitat;
        this.diet = diet;
        this.sound = sound;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSpecies() {
        return species;
    }

    public String getHabitat() {
        return habitat;
    }

    public String getDiet() {
        return diet;
    }

    public String getSound() {
        return sound;
    }

    public String getColor() {
        return color;
    }

}
