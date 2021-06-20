package StacksAndQueues;

import java.util.Scanner;

// Разбор и вычисление постфиксных арифметических выражений
public class PostfixApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter postfix expression: ");
            String input = scanner.next();
            ParsePost parser = new ParsePost(input);
            System.out.println(parser.parse());
        }
    }
}

class ParsePost {
    private final String input;

    public ParsePost(String s) {
        input = s;
    }

    public int parse() {
        StackX stack = new StackX(20);
        char ch;
        int num1, num2, interAns;

        for (int i = 0; i < input.length(); i++) {
            ch = input.charAt(i);
            stack.displayStack("" + ch + " ");

            if (ch >= '0' && ch <= '9') {
                stack.push(ch - '0');
            } else {
                num2 = stack.pop();
                num1 = stack.pop();

                switch (ch) {
                    case '+':
                        interAns = num1 + num2;
                        break;
                    case '-':
                        interAns = num1 - num2;
                        break;
                    case '*':
                        interAns = num1 * num2;
                        break;
                    case '/':
                        interAns = num1 / num2;
                        break;
                    default:
                        interAns = 0;
                }

                stack.push(interAns);
            }
        }

        return stack.pop();
    }
}
