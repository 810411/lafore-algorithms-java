package Trees234;

import java.io.IOException;
import java.util.Scanner;

public class Tree234App {
    public static void main(String[] args) throws IOException {
        long value;
        Tree234 tree234 = new Tree234();
        tree234.insert(50);
        tree234.insert(40);
        tree234.insert(60);
        tree234.insert(30);
        tree234.insert(70);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Enter first letter of show, insert, find or quit to exit:");
            String choice = sc.next();
            if (choice.equals("q"))
                break;
            switch (choice) {
                case "s":
                    tree234.displayTree();
                    break;
                case "i":
                    System.out.print("Enter value to insert: ");
                    value = sc.nextInt();
                    tree234.insert(value);
                    break;
                case "f":
                    System.out.print("Enter value to find: ");
                    value = sc.nextInt();
                    int found = tree234.find(value);
                    if (found != -1)
                        System.out.println("Found " + value);
                    else
                        System.out.println("Could not find " + value);
                    break;
                default:
                    System.out.println("Invalid entry ");
            }
        }
    }
}

class DataItem {
    public long dData;

    public DataItem(long dd) {
        dData = dd;
    }

    public void displayItem() {
        System.out.print(" /" + dData);
    }
}

class Node {
    private static final int ORDER = 4;
    private int numItems;
    private Node parent;
    private Node[] childArray = new Node[ORDER];
    private DataItem[] itemArray = new DataItem[ORDER - 1];

    public void connectChild(int childNum, Node child) {
        childArray[childNum] = child;
        if (child != null)
            child.parent = this;
    }

    public Node disconnectChild(int childNum) {
        Node tempNode = childArray[childNum];
        childArray[childNum] = null;
        return tempNode;
    }

    public Node getChild(int childNum) {
        return childArray[childNum];
    }

    public Node getParent() {
        return parent;
    }

    public boolean isLeaf() {
        return childArray[0] == null;
    }

    public int getNumItems() {
        return numItems;
    }

    public DataItem getItem(int index) {
        return itemArray[index];
    }

    public boolean isFull() {
        return numItems == ORDER - 1;
    }

    public int findItem(long key) {
        for (int j = 0; j < ORDER - 1; j++) {
            if (itemArray[j] == null)
                break;
            else if (itemArray[j].dData == key)
                return j;
        }
        return -1;
    }

    public int insertItem(DataItem newItem) {
        numItems++;
        long newKey = newItem.dData;
        for (int j = ORDER - 2; j >= 0; j--) {
            if (itemArray[j] != null) {
                long itsKey = itemArray[j].dData;
                if (newKey < itsKey)
                    itemArray[j + 1] = itemArray[j];
                else {
                    itemArray[j + 1] = newItem;
                    return j + 1;
                }
            }
        }
        itemArray[0] = newItem;
        return 0;
    }

    public DataItem removeItem() {
        DataItem temp = itemArray[numItems - 1];
        itemArray[numItems - 1] = null;
        numItems--;
        return temp;
    }

    public void displayNode() {
        for (int j = 0; j < numItems; j++)
            itemArray[j].displayItem();
        System.out.println(" /");
    }
}

class Tree234 {
    private Node root = new Node();

    public int find(long key) {
        Node curNode = root;
        int childNumber;
        while (true) {
            if ((childNumber = curNode.findItem(key)) != -1)
                return childNumber;
            else if (curNode.isLeaf())
                return -1;
            else
                curNode = getNextChild(curNode, key);
        }
    }

    public void insert(long dValue) {
        Node curNode = root;
        DataItem tempItem = new DataItem(dValue);
        while (true) {
            if (curNode.isFull()) {
                split(curNode);
                curNode = curNode.getParent();
                curNode = getNextChild(curNode, dValue);
            } else if (curNode.isLeaf())
                break;
            else
                curNode = getNextChild(curNode, dValue);
        }
        curNode.insertItem(tempItem);
    }

    public void split(Node thisNode) {
        DataItem itemB, itemC;
        Node parent, child2, child3;
        int itemIndex;
        itemC = thisNode.removeItem();
        itemB = thisNode.removeItem();
        child2 = thisNode.disconnectChild(2);
        child3 = thisNode.disconnectChild(3);
        Node newRight = new Node();
        if (thisNode == root) {
            root = new Node();
            parent = root;
            root.connectChild(0, thisNode);
        } else
            parent = thisNode.getParent();
        itemIndex = parent.insertItem(itemB);
        int n = parent.getNumItems();
        for (int j = n - 1; j > itemIndex; j--) {
            Node temp = parent.disconnectChild(j);
            parent.connectChild(j + 1, temp);
        }
        parent.connectChild(itemIndex + 1, newRight);
        newRight.insertItem(itemC);
        newRight.connectChild(0, child2);
        newRight.connectChild(1, child3);
    }

    public Node getNextChild(Node theNode, long theValue) {
        int j;
        int numItems = theNode.getNumItems();
        for (j = 0; j < numItems; j++) {
            if (theValue < theNode.getItem(j).dData)
                return theNode.getChild(j);
        }
        return theNode.getChild(j);
    }

    public void displayTree() {
        recDisplayTree(root, 0, 0);
    }

    private void recDisplayTree(Node thisNode, int level,
                                int childNumber) {
        System.out.print("level = " + level + " child = " + childNumber + " ");
        thisNode.displayNode();
        int numItems = thisNode.getNumItems();
        for (int j = 0; j < numItems + 1; j++) {
            Node nextNode = thisNode.getChild(j);
            if (nextNode != null)
                recDisplayTree(nextNode, level + 1, j);
            else
                return;
        }
    }
}
