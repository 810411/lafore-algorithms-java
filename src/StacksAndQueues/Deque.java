package StacksAndQueues;

// Двусторонная очередь
public class Deque {
    private final int[] queArray;
    private int front;
    private int rear;

    public Deque(int maxSize) {
        queArray = new int[maxSize + 1];
        front = 0;
        rear = -1;
    }

    public void insertRight(int j) {
        if (rear == queArray.length - 1) {
            rear = -1;
        }
        queArray[++rear] = j;
    }

    public int removeRight() {
        int temp = queArray[front++];
        if(front == queArray.length) {
            front = 0;
        }
        return temp;
    }

    public void insertLeft(int j) {
        if (front == 0) {
            front = queArray.length;
        }
        queArray[--front] = j;
    }

    public int removeLeft() {
        int temp = queArray[rear--];
        if(rear == -1) {
            rear = queArray.length - 1;
        }
        return temp;
    }

    public boolean isEmpty() {
        return rear + 1 == front || front + queArray.length - 1 == rear;
    }

    public boolean isFull() {
        return rear + 2 == front || front + queArray.length - 2 == rear;
    }
}
