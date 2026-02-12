package d4.Comparing;

public class LPAStudent extends StudentTester {

    private double percentComplete;

    public LPAStudent() {
        percentComplete = random.nextDouble(0, 100.001);

    }

    @Override
    public String toString() {
        return "LPAStudent{"
                + super.toString()
                + ", percentComplete=" + percentComplete
                + '}';
    }

}
