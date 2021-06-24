package Recursion;

import Common.Utils;

import java.util.Arrays;

// Рекурсивная реализация сортировки слиянием (O(n*log(n)))
public class MergeSortApp {
    public static void main(String[] args) {
        int[] arr = Utils.fillArr(10);
        System.out.println(Arrays.toString(arr));

        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr) {
        int[] workSpace = new int[arr.length];
        recMergeSort(arr, workSpace, 0, arr.length - 1);
    }

    private static void recMergeSort(int[] arr, int[] workSpace, int lowerBound, int upperBound) {
        if (lowerBound == upperBound)
            return;

        else {
            int mid = (lowerBound + upperBound) / 2;

            recMergeSort(arr, workSpace, lowerBound, mid);
            recMergeSort(arr, workSpace, mid + 1, upperBound);

            merge(arr, workSpace, lowerBound, mid + 1, upperBound);

        }
    }

    private static void merge(int[] arr, int[] workSpace, int lowPtr, int highPtr, int upperBound) {
        int j = 0;
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound + 1;

        while (lowPtr <= mid && highPtr <= upperBound) {
            if (arr[lowPtr] < arr[highPtr]) {
                workSpace[j++] = arr[lowPtr++];
            } else {
                workSpace[j++] = arr[highPtr++];
            }
        }

        while (lowPtr <= mid)
            workSpace[j++] = arr[lowPtr++];

        while (highPtr <= upperBound)
            workSpace[j++] = arr[highPtr++];

        for (j = 0; j < n; j++) {
            arr[lowerBound + j] = workSpace[j];
        }
    }
}
