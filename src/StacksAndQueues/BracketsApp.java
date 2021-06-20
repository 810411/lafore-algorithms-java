package StacksAndQueues;

import java.util.Scanner;

// Использование стека для поиска парных скобок
public class BracketsApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter string for brackets pairs check: ");
            String input = scanner.next();
            BracketsChecker checker = new BracketsChecker(input);
            checker.check();
        }
    }
}

class BracketsChecker {
    private final String input;

    public BracketsChecker(String in) {
        input = in;
    }

    public void check() {
        StackX stack = new StackX(input.length());

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            switch (ch) {
                case '{':
                case '[':
                case '(':
                    stack.push(ch);
                    break;
                case '}':
                case ']':
                case ')':
                    if (!stack.isEmpty()) {
                        char chx = (char) stack.pop();
                        if ((ch == '}' && chx != '{') || (ch == ']' && chx != '[') || (ch == ')' && chx != '(')) {
                            System.out.println("Error: " + ch + " at " + i);
                        }
                    } else {
                        System.out.println("Error: " + ch + " at " + i);
                    }
                    break;
                default:
                    break;
            }
        }

        if (!stack.isEmpty()) {
            System.out.println("Error: missing right delimiter");
        }
    }
}
