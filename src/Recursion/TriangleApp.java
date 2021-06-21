package Recursion;

import java.util.Scanner;

// Вычисление треуголных чисел
public class TriangleApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a number: ");
            int n = scanner.nextInt();
            int answer = triangle(n);
            System.out.println("Triangle = " + answer);
        }
    }

    private static int triangle(int n) {
        if (n == 1)
            return 1;
        else
            return n + triangle(n - 1);
    }
}
