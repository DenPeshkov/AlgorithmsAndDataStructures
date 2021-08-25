package com.github.denpeshkov.algorithms.sorting.quick;

import com.github.denpeshkov.algorithms.sorting.quick.partition.ThreeWayPartition;
import com.github.denpeshkov.algorithms.sorting.quick.partition.ThreeWayPartition.Pivots;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort3Way {

  public static <T extends Comparable<? super T>> void sort(T[] arr) {
    sort(arr, 0, arr.length - 1);
  }

  private static <T extends Comparable<? super T>> void sort(T[] arr, int lo, int hi) {
    if (hi <= lo) {
      return;
    }

    int pivot = lo + ThreadLocalRandom.current().nextInt(hi - lo + 1);
    Pivots pivots = ThreeWayPartition.partition(arr, lo, hi, pivot);

    sort(arr, lo, pivots.lo() - 1);
    sort(arr, pivots.hi() + 1, hi);
  }
}
