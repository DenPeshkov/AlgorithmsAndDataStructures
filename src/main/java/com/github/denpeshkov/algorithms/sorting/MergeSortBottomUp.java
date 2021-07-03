package com.github.denpeshkov.algorithms.sorting;

public class MergeSortBottomUp {
    public static <T extends Comparable<? super T>> void sort(T[] arr) {
        T[] aux = (T[]) new Comparable[arr.length];
        for (int sz = 1; sz < arr.length; sz *= 2)
            for (int i = 0; i < arr.length - sz; i += sz * 2)
                merge(arr, aux, i, i + sz - 1, Math.min(i + 2 * sz - 1, arr.length - 1));
    }

    private static <T extends Comparable<? super T>> void merge(T[] arr, T[] aux, int p, int q, int r) {
        System.arraycopy(arr, p, aux, p, r - p + 1);

        for (int k = p, i = p, j = q + 1; k <= r; k++) {
            if (i > q) arr[k] = aux[j++];
            else if (j > r) arr[k] = aux[i++];
            else if (aux[j].compareTo(aux[i]) < 0) arr[k] = aux[j++];
            else arr[k] = aux[i++];
        }
    }
}
