package SimpleSorting;

import Common.Utils;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = Utils.fillArr(32);
        System.out.println("Before: \n" + Arrays.toString(arr));

        int[] arrForBubbleSort = arr.clone();
        BubbleSort.sort(arrForBubbleSort);
        System.out.println("Bubble sort: \n" + Arrays.toString(arrForBubbleSort));

        int[] arrForSelectionSort = arr.clone();
        SelectionSort.sort(arrForSelectionSort);
        System.out.println("Selection sort: \n" + Arrays.toString(arrForSelectionSort));

        int[] arrForInsertionSort = arr.clone();
        InsertionSort.sort(arrForInsertionSort);
        System.out.println("Insertion sort: \n" + Arrays.toString(arrForInsertionSort));

        int[] arrForBubbleShakeSort = arr.clone();
        BubbleShakeSort.sort(arrForBubbleShakeSort);
        System.out.println("Bubble shake sort: \n" + Arrays.toString(arrForBubbleShakeSort));
    }

}
