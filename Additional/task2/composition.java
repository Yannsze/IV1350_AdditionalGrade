import java.util.Random;

// Composition: Wrapping Random and delegating methods
class MyRandomComposition {
    private Random random;

    public MyRandomComposition() {
        this.random = new Random();
    }

    // Delegates to Random's nextInt
    public int nextInt(int bound) {
        return random.nextInt(bound);
    }

    // Adds a method to generate a random even integer between 0 (inclusive) and bound (exclusive)
    public int nextEvenInt(int bound) {
        int n = random.nextInt(bound / 2) * 2;
        return n;
    }
}