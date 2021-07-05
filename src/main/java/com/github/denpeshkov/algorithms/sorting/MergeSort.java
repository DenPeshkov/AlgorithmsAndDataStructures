package com.github.denpeshkov.algorithms.sorting;

public class MergeSort {
  public static <T extends Comparable<? super T>> void sort(T[] arr) {
    T[] aux = (T[]) new Comparable[arr.length];
    sort(arr, aux, 0, arr.length - 1);
  }

  private static <T extends Comparable<? super T>> void sort(T[] arr, T[] aux, int p, int r) {
    if (r <= p) return;

    int q = (p + r) >>> 1;
    sort(arr, aux, p, q);
    sort(arr, aux, q + 1, r);
    merge(arr, aux, r, p, q);
  }

  private static <T extends Comparable<? super T>> void merge(
      T[] arr, T[] aux, int p, int q, int r) {
    System.arraycopy(arr, p, aux, p, r - p + 1);

    for (int k = p, i = p, j = q + 1; k <= r; k++) {
      if (i > q) arr[k] = aux[j++];
      else if (j > r) arr[k] = aux[i++];
      else if (aux[j].compareTo(aux[i]) < 0) arr[k] = aux[j++];
      else arr[k] = aux[i++];
    }
  }
}
