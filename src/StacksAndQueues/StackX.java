package StacksAndQueues;

// Стек, реализация
public class StackX {
    private final int[] stackArray; // хранилище
    private int top; // вершина стека

    public StackX(int maxSize) {
        stackArray = new int[maxSize];
        top = -1;
    }

    // Вставка элемента в стек (на вершину)
    public void push(int j) {
        stackArray[++top] = j;
    }

    // Извлечение элемента с вершины стека
    public int pop() {
        return stackArray[top--];
    }

    // Чтение элемента с вершины
    public int peek() {
        return stackArray[top];
    }

    // Чтение элемента по индексу
    public int peekN(int n) {
        return stackArray[n];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == stackArray.length - 1;
    }

    public int size() {
        return top + 1;
    }

    public void displayStack(String s) {
        System.out.print(s + " Stack (bottom -> top): ");
        for (int i = 0; i < size(); i++) {
            System.out.print(peekN(i) + " ");
        }
        System.out.println();
    }
}
