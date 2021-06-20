package StacksAndQueues;

// Очередь, реализация
public class Queue {
    private final int[] queArray;
    private int front;
    private int rear;

    public Queue(int maxSize) {
        queArray = new int[maxSize + 1];
        front = 0;
        rear = -1;
    }

    public void insert(int j) {
        if (rear == queArray.length - 1) {
            rear = -1;
        }
        queArray[++rear] = j;
    }

    public int remove() {
        int temp = queArray[front++];
        if(front == queArray.length) {
            front = 0;
        }
        return temp;
    }

    public int peek() {
        return queArray[front];
    }

    public boolean isEmpty() {
        return rear + 1 == front || front + queArray.length - 1 == rear;
    }

    public boolean isFull() {
        return rear + 2 == front || front + queArray.length - 2 == rear;
    }

    public int size() {
        if (rear >= front) {
            return rear - front + 1;
        }

        return queArray.length - front + rear + 1;
    }

}
