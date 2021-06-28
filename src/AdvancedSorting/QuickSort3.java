package AdvancedSorting;

import Common.Utils;

// Быстрая сортировка с сортировкой малых подмассивов методом вставки
public class QuickSort3 {
    private static int[] arr;

    public static void sort(int[] array) {
        arr = array;
        recSort(0, arr.length - 1);
    }

    private static void recSort(int left, int right) {
        if (right - left + 1 < 10)
            insertionSort(left, right);
        else {
            int median = medianOf3(left, right);
            int partition = partitionIt(left, right, median);

            recSort(left, partition - 1);
            recSort(partition + 1, right);
        }
    }

    private static void insertionSort(int left, int right) {
        int in, out;

        for (out = left + 1; out <= right; out++) {
            int temp = arr[out];
            in = out;

            while (in > left && arr[in - 1] >= temp) {
                arr[in] = arr[in - 1];
                --in;
            }

            arr[in] = temp;
        }
    }

    private static int medianOf3(int left, int right) {
        int center = (left + right) / 2;

        if (arr[left] > arr[center])
            Utils.swap(arr, left, center);
        if (arr[left] > arr[right])
            Utils.swap(arr, left, right);
        if (arr[center] > arr[right])
            Utils.swap(arr, center, right);

        Utils.swap(arr, center, right - 1);

        return arr[right - 1];
    }

    private static int partitionIt(int left, int right, int pivot) {
        int leftPtr = left;
        int rightPtr = right - 1;

        while (true) {
            while (arr[++leftPtr] < pivot);
            while (arr[--rightPtr] > pivot);

            if (leftPtr >= rightPtr)
                break;
            else
                Utils.swap(arr, leftPtr, rightPtr);
        }

        Utils.swap(arr, leftPtr, right - 1);
        return leftPtr;
    }
}
