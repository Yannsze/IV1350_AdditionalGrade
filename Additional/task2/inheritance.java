import java.util.Random;

// Inheritance: Extending Random to add a method
class MyRandomInheritance extends Random {
    // Adds a method to generate a random even integer between 0 (inclusive) and bound (exclusive)
    public int nextEvenInt(int bound) {
        int n = nextInt(bound / 2) * 2;
        return n;
    }
}