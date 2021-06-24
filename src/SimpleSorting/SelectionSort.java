package SimpleSorting;

import Common.Utils;

// Сортировка методом выбора (O(n^2))
public class SelectionSort {
    public static void sort(int[] arr) {
        int min;
        for (int out = 0; out < arr.length - 1; out++) {
            min = out;

            for(int in = out + 1; in < arr.length; in++) {
                if (arr[in] < arr[min]) {
                    min = in;
                }
            }

            Utils.swap(arr, out, min);
        }
    }
}
