package com.github.denpeshkov.algorithms.sorting.quick;

import com.github.denpeshkov.algorithms.sorting.quick.partition.HoarePartition;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {

  public static <T extends Comparable<? super T>> void sort(T[] arr) {
    sort(arr, 0, arr.length - 1);
  }

  private static <T extends Comparable<? super T>> void sort(T[] arr, int lo, int hi) {
    if (hi <= lo) {
      return;
    }

    int pivot = lo + ThreadLocalRandom.current().nextInt(hi - lo + 1);

    pivot = HoarePartition.partition(arr, lo, hi, pivot);

    sort(arr, lo, pivot - 1);
    sort(arr, pivot + 1, hi);
  }
}
