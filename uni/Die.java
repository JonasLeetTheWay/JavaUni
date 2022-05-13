public class Die {
    private int value;

    public Die() {
        this.toss();
    }

    public void toss() {
        int random = (int) (6 * Math.random());

        while (random == 0) {
            random = (int) (6 * Math.random());
        }
        this.value = random;
    }

    public int getTossedValue() {
        return value;
    }
}
