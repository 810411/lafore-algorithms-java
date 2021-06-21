package LinkedLists;

// Сортированный связный список
public class SortedList {
    private Link first;

    public SortedList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insert(int key) {
        Link newLink = new Link(key);
        Link prev = null;
        Link current = first;

        while (current != null && key > current.i) {
            prev = current;
            current = current.next;
        }

        if (prev == null)
            first = newLink;
        else
            prev.next = newLink;

        newLink.next = current;
    }

    public Link remove() {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public void displayList() {
        System.out.print("List (first-->last): ");
        Link current = first;
        while (current != null) {
            System.out.print(current + " ");
            current = current.next;
        }
        System.out.println();
    }

}
