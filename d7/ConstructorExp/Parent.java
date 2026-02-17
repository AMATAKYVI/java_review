package d7.ConstructorExp;

public class Parent {

    private String name;
    private String dob;


    {
        name = "Miker";
        dob = "1990-10-10";

        System.out.println(name);
    }

    public Parent() {
        System.out.println("Parent()");
    }


    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Parent{" + "name=" + name + ", dob=" + dob + '}';
    }
}
