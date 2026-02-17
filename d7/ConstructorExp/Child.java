package d7.ConstructorExp;

public class Child extends Parent {

    public Child() {
        System.out.println("Child()");
    }

    @Override
    public String toString() {
        return "Child";
    }
}
