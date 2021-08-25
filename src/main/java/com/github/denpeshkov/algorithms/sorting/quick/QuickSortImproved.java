package com.github.denpeshkov.algorithms.sorting.quick;

import com.github.denpeshkov.algorithms.sorting.insertion.InsertionSort;
import com.github.denpeshkov.algorithms.sorting.quick.partition.ThreeWayPartition;
import com.github.denpeshkov.algorithms.sorting.quick.partition.ThreeWayPartition.Pivots;
import java.util.concurrent.ThreadLocalRandom;

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

      int pivot = lo + ThreadLocalRandom.current().nextInt(hi - lo + 1);

      Pivots pivots = ThreeWayPartition.partition(arr, lo, hi, pivot);

      // tail recursion elimination
      if (pivots.lo() - lo <= hi - pivots.hi()) {
        sort(arr, lo, pivots.lo() - 1);
        lo = pivots.hi() + 1;
      } else {
        sort(arr, pivots.hi() + 1, hi);
        hi = pivots.lo() - 1;
      }
    }
  }
}
