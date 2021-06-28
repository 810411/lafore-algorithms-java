package AdvancedSorting;

import Common.Utils;
import SimpleSorting.BubbleSort;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = Utils.fillArr(32);
        System.out.println("Before: \n" + Arrays.toString(arr));

        int[] arrForShellSort = arr.clone();
        ShellSort.sort(arrForShellSort);
        System.out.println("Shell sort: \n" + Arrays.toString(arrForShellSort));

        int[] arrForQuickSort = arr.clone();
        QuickSort.sort(arrForQuickSort);
        System.out.println("Quick sort: \n" + Arrays.toString(arrForQuickSort));

        int[] arrForQuickSort2 = arr.clone();
        QuickSort2.sort(arrForQuickSort2);
        System.out.println("Quick sort: \n" + Arrays.toString(arrForQuickSort2));

        int[] arrForQuickSort3 = arr.clone();
        QuickSort3.sort(arrForQuickSort3);
        System.out.println("Quick sort: \n" + Arrays.toString(arrForQuickSort3));

    }
}
