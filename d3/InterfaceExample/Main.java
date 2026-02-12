package d3.InterfaceExample;

import d3.InterfaceExample.FlightEnabled;

public class Main {

    public static void main(String[] args) {
        FlightEnabled[] flyingCreatures = new FlightEnabled[2];
        flyingCreatures[0] = (FlightEnabled) new Bird();

        for (FlightEnabled creature : flyingCreatures) {
            creature.fly();
        }

    }
}
