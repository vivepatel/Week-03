package runtimeanalysis.recursivevsiterative;

import static java.lang.System.nanoTime;

public class RecursiveVSIterative {

    static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    static int fibonacciIterative(int n) {
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {

        long starttime = nanoTime();
        fibonacciRecursive(10);
        System.out.println("Recursive Fibonacci for 10 takes "+(nanoTime()-starttime));

        starttime = nanoTime();
        fibonacciIterative(10);
        System.out.println("Iterative Fibonacci for 10 takes "+(nanoTime()-starttime));

        starttime = nanoTime();
        fibonacciRecursive(30);
        System.out.println("\nRecursive Fibonacci for 30 takes "+(nanoTime()-starttime));

        starttime = nanoTime();
        fibonacciIterative(30);
        System.out.println("Iterative Fibonacci for 30 takes "+(nanoTime()-starttime));

        starttime = nanoTime();
//        fibonacciRecursive(50);
        System.out.println("\nRecursive Fibonacci for 50 takes a lot of Time");

        starttime = nanoTime();
        fibonacciIterative(50);
        System.out.println("Iterative Fibonacci for 50 takes "+(nanoTime()-starttime));
    }
}
