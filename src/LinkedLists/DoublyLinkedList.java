package LinkedLists;

// Двусвязный список
public class DoublyLinkedList {
    private Link first;
    public Link last;

    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int i) {
        Link newLink = new Link(i);
        if (isEmpty())
            last = newLink;
        else
            first.prev = newLink;
        newLink.next = first;
        first = newLink;
    }

    public void insertLast(int i) {
        Link newLink = new Link(i);
        if(isEmpty())
            first = newLink;
        else {
            last.next = newLink;
            newLink.prev = last;
        }
        last = newLink;
    }

    public Link deleteFirst() {
        Link temp = first;
        if (first.next == null)
            last = null;
        else
            first.next.prev = null;
        first = first.next;
        return temp;
    }

    public Link deleteLast() {
        Link temp = last;
        if (first.next == null)
            first = null;
        else
            last.prev.next = null;
        last = last.prev;
        return temp;
    }
}
