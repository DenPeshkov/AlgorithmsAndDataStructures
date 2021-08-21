package com.github.denpeshkov.algorithms.sorting.merge;

import com.github.denpeshkov.algorithms.merge.binary.BinaryMerge;

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

    BinaryMerge.merge(arr, aux, lo, mid, hi);
  }
}
