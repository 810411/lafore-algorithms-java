package LinkedLists;

// Объект "ссылка" для связных списков
public class Link {
    public int i;
    public Link next;

    public Link(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return String.format("{ %d }", i);
    }
}
