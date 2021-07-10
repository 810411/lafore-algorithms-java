package HashTables;

// Реализация хеш-таблицы с линейным пробированием
public class HashTable {
    private DataItem[] hashArray;
    private DataItem nonItem;

    public HashTable(int size) {
        hashArray = new DataItem[size];
        nonItem = new DataItem(-1);
    }

    public void displayTable() {
        System.out.print("Table: ");
        for (int i = 0; i < hashArray.length; i++) {
            if (hashArray[i] != null)
                System.out.print(hashArray[i].getKey() + " ");
            else
                System.out.print("** ");
        }
        System.out.println();
    }

    public int hashFunc(int key) {
        return key % hashArray.length;
    }

    public void insert(DataItem item) {
        int key = item.getKey();
        int hashVal = hashFunc(key);

        while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
            ++hashVal;
            hashVal %= hashArray.length;
        }

        hashArray[hashVal] = item;
    }

    public DataItem delete(int key) {
        int hashVal = hashFunc(key);

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                DataItem temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                return temp;
            }
            ++hashVal;
            hashVal %= hashArray.length;
        }

        return null;
    }

    // метод предполагает что хеш-таблица не заполнена полностью
    public DataItem find(int key) {
        int hashVal = hashFunc(key);

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key)
                return hashArray[hashVal];

            ++hashVal;
            hashVal %= hashArray.length;
        }

        return null;
    }
}

