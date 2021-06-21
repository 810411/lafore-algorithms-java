package LinkedLists;

// Простой связный список целочисленных значений
public class LinkList {
    private Link first;

    public LinkList() {
        first = null;
    }

    public void insertFirst(int i) {
        Link newLink = new Link(i);
        newLink.next = first;
        first = newLink;
    }

    public Link find(int key) {
        Link current = first;
        while (current.i != key) {
            if (current.next == null)
                return null;
            else
                current = current.next;
        }
        return current;
    }

    public Link delete() {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public Link delete(int key) {
        Link current = first;
        Link prev = first;
        while (current.i != key) {
            if (current.next == null)
                return null;
            else {
                prev = current;
                current = current.next;
            }
        }
        if (current == first)
            first = first.next;
        else
            prev.next = current.next;

        return current;
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

    public boolean isEmpty() {
        return first == null;
    }

}
