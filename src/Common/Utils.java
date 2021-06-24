package Common;

import java.util.Random;

public class Utils {
    public static void swap(int[] arr, int one, int two) {
        int temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }

    public static int[] fillArr(int maxSize) {
        Random random = new Random();
        int[] arr = new int[maxSize];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(arr.length);
        }

        return arr;
    }
}
