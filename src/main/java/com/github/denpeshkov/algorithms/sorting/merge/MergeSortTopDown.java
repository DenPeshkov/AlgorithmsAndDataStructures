package com.github.denpeshkov.algorithms.sorting.merge;

public class MergeSortTopDown {

  public static <T extends Comparable<? super T>> void sort(T[] arr) {
    T[] aux = (T[]) new Comparable[arr.length];
    sort(arr, aux, 0, arr.length - 1);
  }

  private static <T extends Comparable<? super T>> void sort(T[] arr, T[] aux, int lo, int hi) {
    if (hi <= lo) {
      return;
    }

    int mid = (lo + hi) >>> 1;
    sort(arr, aux, lo, mid);
    sort(arr, aux, mid + 1, hi);

    MergeSortUtil.merge(arr, aux, hi, lo, mid);
  }
}
