package Recursion;

import java.util.Scanner;

// Вычисление факториала
public class FactorialApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a number: ");
            int n = scanner.nextInt();
            int answer = factorial(n);
            System.out.println("Factorial = " + answer);
        }
    }

    private static int factorial(int n) {
        if (n == 0)
            return 1;
        else
            return n * factorial(n - 1);
    }
}
