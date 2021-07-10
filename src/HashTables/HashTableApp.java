package HashTables;

public class HashTableApp {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(32);

        for (int i = 0; i < 30; i++) {
            DataItem item = new DataItem((int) (Math.random() * 30));
            hashTable.insert(item);
        }

        hashTable.displayTable();
    }
}
