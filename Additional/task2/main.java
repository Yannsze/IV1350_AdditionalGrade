public class main {
public static void main(String[] args) {
        System.out.println("Inheritenace:");
        MyRandomInheritance inhRand = new MyRandomInheritance();
        System.out.println("Random int: " + inhRand.nextInt(10));
        System.out.println("Random even int: " + inhRand.nextEvenInt(10));

        System.out.println("\nComposition:");
        MyRandomComposition compRand = new MyRandomComposition();
        System.out.println("Random int: " + compRand.nextInt(10));
        System.out.println("Random even int: " + compRand.nextEvenInt(10));
    }
}
