package StacksAndQueues;

public class Test {
    public static void main(String[] args) {
        // Пример со стеком
        StackX stack = new StackX(10);
        stack.push(20);
        stack.push(40);
        stack.push(60);
        stack.push(80);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " "); // 80 60 40 20
        }
        System.out.println();

        // Пример с очередью
        Queue queue = new Queue(5);
        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.insert(40);
        queue.remove();
        queue.remove();
        queue.remove();
        queue.insert(50);
        queue.insert(60);
        queue.insert(70);
        queue.insert(80);

        while (!queue.isEmpty()) {
            System.out.print(queue.remove() + " "); // 40 50 60 70 80
        }
        System.out.println();

        // Пример с приоритетной очередью
        PriorityQ pq = new PriorityQ(5);
        pq.insert(30);
        pq.insert(50);
        pq.insert(10);
        pq.insert(40);
        pq.insert(20);

        while (!pq.isEmpty()) {
            System.out.print(pq.remove() + " "); // 10 20 30 40 50
        }
        System.out.println();
    }

}
