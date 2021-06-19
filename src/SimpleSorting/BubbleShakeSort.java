package SimpleSorting;

// Пузырьковая сортировка со встряхиванием
public class BubbleShakeSort {
    public static void sort(int[] arr) {
        for (int right = arr.length - 1, left = 0; right > left; right--, left++) {
            for(int in = left; in < right; in++) {
                if (arr[in] > arr[in + 1]) {
                    Utils.swap(arr, in, in + 1);
                }
            }
            for(int in = right; in > left; in--) {
                if (arr[in] < arr[in - 1]) {
                    Utils.swap(arr, in, in - 1);
                }
            }
        }
    }
}
