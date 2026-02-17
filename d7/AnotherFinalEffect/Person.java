package d7.AnotherFinalEffect;

public class Person {

    private final String name;
    private final int age;
    private Person[] kids;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        kids = new Person[0];
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Person[] getKids() {
        return kids;
    }
}
