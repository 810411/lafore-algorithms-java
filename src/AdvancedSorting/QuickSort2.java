package AdvancedSorting;

import Common.Utils;

// Быстрая сортировка с определением медианы по трем точкам
public class QuickSort2 {
    private static int[] arr;

    public static void sort(int[] array) {
        arr = array;
        recSort(0, arr.length - 1);
    }

    private static void recSort(int left, int right) {
        if (right - left + 1 <= 3)
            manualSort(left, right);
        else {
            int median = medianOf3(left, right);
            int partition = partitionIt(left, right, median);

            recSort(left, partition - 1);
            recSort(partition + 1, right);
        }
    }

    private static void manualSort(int left, int right) {
        int size = right - left + 1;
        if (size <= 1)
            return;
        else if (size == 2) {
            if (arr[left] > arr[right])
                Utils.swap(arr, left, right);
            return;
        } else {
            if (arr[left] > arr[right - 1])
                Utils.swap(arr, left, right - 1);
            if (arr[left] > arr[right])
                Utils.swap(arr, left, right);
            if (arr[right - 1] > arr[right])
                Utils.swap(arr, right - 1, right);
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
