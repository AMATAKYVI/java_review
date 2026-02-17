package d7.EnumExp;

public enum Generation {
    I("First"), II("Second"), III("Third"), IV("Fourth"), V("Fifth"), VI("Sixth"), VII("Seventh"), VIII("Eighth"), IX1("Ninth"), X1("Tenth"), IX("Eleventh"), X("Twelfth");

    String name;

    Generation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
