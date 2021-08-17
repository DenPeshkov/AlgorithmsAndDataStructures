package com.github.denpeshkov.algorithms.sorting.quick;

import com.github.denpeshkov.algorithms.sorting.quick.ThreeWayPartition.Pivot;

public class QuickSort3Way {

  public static <T extends Comparable<? super T>> void sort(T[] arr) {
    sort(arr, 0, arr.length - 1);
  }

  private static <T extends Comparable<? super T>> void sort(T[] arr, int lo, int hi) {
    if (hi <= lo) {
      return;
    }

    Pivot pivot = ThreeWayPartition.partition(arr, lo, hi);

    sort(arr, lo, pivot.lo() - 1);
    sort(arr, pivot.hi() + 1, hi);
  }
}
