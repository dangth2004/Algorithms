package algorithm_design.recursion;

public class Fibonacci {
    /**
     * Function to find the n-th Fibonacci number.
     */
    public static int fibonacci(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int n = 8;
        System.out.println(fibonacci(n));
    }
}
