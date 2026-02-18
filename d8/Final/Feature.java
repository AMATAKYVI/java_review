package d8.Final;

public enum Feature {

    ALLIGATOR(-45),
    ALOE(5),
    JELLYFISH(-10),
    PEARL_NECKLACE(50),
    SILVER_COIN(10),
    SNAKE(-20);

    private final int heathPoints;

    Feature(int heathPoints) {
        this.heathPoints = heathPoints;
    }

    public int getheathPoints() {
        return heathPoints;
    }

}
