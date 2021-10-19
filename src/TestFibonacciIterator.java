import java.util.*;

public class TestFibonacciIterator {
    public static void main(String [] args) {
        // an iterator that produces up to n-th fibonacci numbers (start at 0)
        IterableFibonacci fibNumbers = new IterableFibonacci(15);

        /**System.out.println("Fibonacci numbers up to n = 15");
        for (int fib: fibNumbers) {
            System.out.println(fib);
        }

        System.out.println("Fibonacci numbers up to n = 10");
        fibNumbers.setMaxIndex(10);
        for (int fib: fibNumbers) {
            System.out.println(fib);
        }*/

        Scanner input = new Scanner(System.in);
        System.out.print("Write a Fibonacci number you wish to see iteration of: ");
        int number = input.nextInt();

        System.out.println("Fibonacci numbers up to n = " + number + " is ");
        fibNumbers.setMaxIndex(number);
        for (int fib: fibNumbers) {
            System.out.println(fib);
        }
    }
}