package Recursion;

import java.util.Scanner;

// Построение списка анаграмм
public class AnagramApp {
    private static int size;
    private static int count;
    private static final char[] chars = new char[100];

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a word: ");
            String input = scanner.next();
            size = input.length();
            count = 0;
            for (int i = 0; i < size; i++) {
                chars[i] = input.charAt(i);
            }

            doAnagram(size);
        }
    }

    private static void doAnagram(int newSize) {
        if (newSize == 1)
            return;

        for (int i = 0; i < newSize; i++) {
            doAnagram(newSize - 1);

            if (newSize == 2)
                displayWord();

            rotate(newSize);

        }
    }

    private static void rotate(int newSize) {
        int position = size - newSize;
        char temp = chars[position];
        int i = position + 1;
        for (; i < size; i++) {
            chars[i - 1] = chars[i];
        }
        chars[i - 1] = temp;
    }

    private static void displayWord() {
        System.out.printf("%-4d", ++count);
        for (int i = 0; i < size; i++) {
            System.out.print(chars[i]);
        }
        System.out.print("\t");
        if (count % 6 == 0)
            System.out.println();
    }
}
