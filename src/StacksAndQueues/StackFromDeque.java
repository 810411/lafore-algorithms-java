package StacksAndQueues;

public class StackFromDeque{
    private final Deque deque;

    public StackFromDeque(int maxSize) {
        deque = new Deque(maxSize);
    }

    public void push(int j) {
        deque.insertLeft(j);
    }

    public int pop() {
        return deque.removeRight();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    public boolean isFull() {
        return deque.isFull();
    }
}
