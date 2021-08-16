package com.github.denpeshkov.algorithms.selection;

import static com.github.denpeshkov.algorithms.sorting.quick.HoarePartition.partition;

public class QuickSelectRecursive {

  public static <T extends Comparable<? super T>> T select(T[] arr, int k) {
    if (k < 1 || k > arr.length) {
      throw new IllegalArgumentException();
    }

    // 0-based indexing
    return select(arr, 0, arr.length - 1, k - 1);
  }

  public static <T extends Comparable<? super T>> T select(T[] arr, int lo, int hi, int k) {
    if (lo == hi) {
      return arr[lo];
    }
    int pivot = partition(arr, lo, hi);
    if (k == pivot) {
      return arr[k];
    } else if (k < pivot) {
      return select(arr, lo, pivot - 1, k);
    } else {
      return select(arr, pivot + 1, hi, k);
    }
  }
}
