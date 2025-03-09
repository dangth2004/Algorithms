package algorithm_design.recursion;

public class TowerOfHanoi {
    private static void moveDisk(int n, String source, String auxiliary, String destination) {
        System.out.printf("Disk %d from %s to %s\n", n, source, destination);
    }

    public static void solveHanoi(int n, String source, String auxiliary, String destination) {
        if (n == 1) {
            moveDisk(n, source, auxiliary, destination);
            return;
        }

        solveHanoi(n - 1, source, destination, auxiliary);
        moveDisk(n, source, auxiliary, destination);
        solveHanoi(n - 1, auxiliary, source, destination);
    }

    public static void main(String[] args) {
        int numberOfDisks = 3;
        System.out.println("Solving Tower of Hanoi with " + numberOfDisks + " disks:");
        solveHanoi(numberOfDisks, "A", "B", "C");
    }
}
