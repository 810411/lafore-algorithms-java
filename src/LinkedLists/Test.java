package LinkedLists;

public class Test {
    public static void main(String[] args) {
        // Пример целочисленного связного списка
        LinkList list = new LinkList();
        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertFirst(4);

        list.displayList();

        Link f = list.find(3);
        if (f != null) {
            System.out.println("Founded: " + f);
            System.out.println("Deleted: " + list.delete(f.i));
        }
        else
            System.out.println("Can't find link for this key");

        list.displayList();
        System.out.println();

        // Пример стека на основе связного списка
        LinkStack stack = new LinkStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println("\n");

        // Пример сортированного связного списка
        SortedList sortedList = new SortedList();
        sortedList.insert(30);
        sortedList.insert(20);
        sortedList.insert(10);
        sortedList.insert(40);

        sortedList.displayList();
        System.out.println();
    }
}
