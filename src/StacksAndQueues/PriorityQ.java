package StacksAndQueues;

// Очередь с приоритетом (вставка O(n) / извлечение O(1))
public class PriorityQ {
    private final int[] queArray;
    private int nItems;

    public PriorityQ(int maxSize) {
        queArray = new int[maxSize];
        nItems = 0;
    }

    public void insert(int item) {
        if (nItems == 0) {
            queArray[nItems++] = item;
            return;
        }

        int i;
        for (i = nItems - 1; i >= 0; i--) {
            if (item > queArray[i]) {
                queArray[i + 1] = queArray[i];
            } else {
                break;
            }
        }

        queArray[i + 1] = item;
        nItems++;
    }

    public int remove() {
        return queArray[--nItems];
    }

    public int peekMin() {
        return queArray[nItems - 1];
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public boolean isFull() {
        return nItems == queArray.length;
    }

}
