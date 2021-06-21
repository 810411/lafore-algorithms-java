package LinkedLists;

// Стек на основе связного списка
public class LinkStack {
    private final LinkList list;

    public LinkStack() {
        list = new LinkList();
    }

    public void push(int i) {
        list.insertFirst(i);
    }

    public int pop() {
        return list.delete().i;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
