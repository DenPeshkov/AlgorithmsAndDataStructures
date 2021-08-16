package com.github.denpeshkov.algorithms.sorting.quick;

import static com.github.denpeshkov.algorithms.sorting.quick.HoarePartition.partition;

public class QuickSort {

  public static <T extends Comparable<? super T>> void sort(T[] arr) {
    sort(arr, 0, arr.length - 1);
  }

  private static <T extends Comparable<? super T>> void sort(T[] arr, int lo, int hi) {
    if (hi <= lo) {
      return;
    }
    int pivot = partition(arr, lo, hi);
    sort(arr, lo, pivot - 1);
    sort(arr, pivot + 1, hi);
  }
}
