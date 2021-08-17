package com.github.denpeshkov.algorithms.sorting.quick;

import com.github.denpeshkov.algorithms.sorting.insertion.InsertionSort;
import com.github.denpeshkov.algorithms.sorting.quick.ThreeWayPartition.Pivot;

public class QuickSortImproved {

  private static final int INSERTION_SORT_CUTOFF = 8;

  public static <T extends Comparable<? super T>> void sort(T[] arr) {
    sort(arr, 0, arr.length - 1);
  }

  private static <T extends Comparable<? super T>> void sort(T[] arr, int lo, int hi) {

    while (lo < hi) {
      // cutoff to insertion sort
      if (hi - lo + 1 <= INSERTION_SORT_CUTOFF) {
        InsertionSort.sort(arr, lo, hi);
        return;
      }

      Pivot pivot = ThreeWayPartition.partition(arr, lo, hi);

      // tail recursion elimination
      if (pivot.lo() - lo <= hi - pivot.hi()) {
        sort(arr, lo, pivot.lo() - 1);
        lo = pivot.hi() + 1;
      } else {
        sort(arr, pivot.hi() + 1, hi);
        hi = pivot.lo() - 1;
      }
    }
  }
}
