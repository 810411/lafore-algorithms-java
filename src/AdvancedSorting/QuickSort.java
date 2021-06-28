package AdvancedSorting;

import Common.Utils;

// Быстрая сортировка (Хоара) (~O(N*logN))
public class QuickSort {
    private static int[] arr;

    public static void sort(int[] array) {
        arr = array;
        recSort(0, arr.length - 1);
    }

    private static void recSort(int left, int right) {
        if (right - left <= 0)
            return;
        else {
            int pivot = arr[right];

            int partition = partitionIt(left, right, pivot);

            recSort(left, partition - 1);
            recSort(partition + 1, right);
        }
    }

    private static int partitionIt(int left, int right, int pivot) {
        int leftPtr = left - 1;
        int rightPtr = right;

        while (true) {
            while (arr[++leftPtr] < pivot);
            while (rightPtr > 0 && arr[--rightPtr] > pivot);

            if (leftPtr >= rightPtr)
                break;
            else
                Utils.swap(arr, leftPtr, rightPtr);
        }

        Utils.swap(arr, leftPtr, right);
        return leftPtr;
    }
}
