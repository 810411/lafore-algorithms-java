package SimpleSorting;

// Пузырьковая сортировка (O(n^2))
public class BubbleSort {
    public static void sort(int[] arr) {
        for (int out = arr.length - 1; out > 1; out--) {
            for(int in = 0; in < out; in++) {
                if (arr[in] > arr[in + 1]) {
                    Utils.swap(arr, in, in + 1);
                }
            }
        }
    }
}
