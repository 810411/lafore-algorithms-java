package Recursion;

import StacksAndQueues.StackX;

import java.util.Scanner;

// Вычисление треуголных чисел (замена рекурсии на стек)
public class TriangleWithStackApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a number: ");
            int n = scanner.nextInt();
            int answer = triangle(n);
            System.out.println("Triangle = " + answer);
        }
    }

    private static int triangle(int n) {
        int answer = 0;
        StackX stack = new StackX(10000);

        while (n > 0) {
            stack.push(n);
            n--;
        }

        while (!stack.isEmpty()) {
            answer += stack.pop();
        }

        return answer;
    }
}
