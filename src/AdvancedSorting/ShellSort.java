package AdvancedSorting;

// Сортиоровка методом Шелла (~O(n*logN^2))
public class ShellSort {
    public static void sort(int[] arr) {
        int inner, outer, temp;
        int h = 1;

        while (h <= arr.length / 3)
            h = h * 3 + 1;

        while (h > 0) {
            for (outer = h; outer < arr.length; outer++) {
                temp = arr[outer];
                inner = outer;

                while (inner > h - 1 && arr[inner - h] >= temp) {
                    arr[inner] = arr[inner - h];
                    inner -= h;
                }

                arr[inner] = temp;
            }

            h = (h - 1) / 3;
        }
    }
}
