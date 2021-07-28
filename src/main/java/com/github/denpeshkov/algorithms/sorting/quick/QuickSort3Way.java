package com.github.denpeshkov.algorithms.sorting.quick;

import java.util.concurrent.ThreadLocalRandom;

public class QuickSort3Way {

  public static <T extends Comparable<? super T>> void sort(T[] arr) {
    sort(arr, 0, arr.length - 1);
  }

  private static <T extends Comparable<? super T>> void sort(T[] arr, int lo, int hi) {
    if (hi <= lo) {
      return;
    }

    exchange(arr, lo, lo + ThreadLocalRandom.current().nextInt(hi - lo + 1));

    int pivot_lo = lo, pivot_mid = lo + 1, pivot_hi = hi;
    T v = arr[lo];
    while (pivot_mid <= pivot_hi) {
      int cmp = arr[pivot_mid].compareTo(v);
      if (cmp < 0) {
        exchange(arr, pivot_lo++, pivot_mid++);
      } else if (cmp > 0) {
        exchange(arr, pivot_mid, pivot_hi--);
      } else {
        pivot_mid++;
      }
    }

    sort(arr, lo, pivot_lo - 1);
    sort(arr, pivot_hi + 1, hi);
  }

  private static <T> void exchange(T[] arr, int i, int j) {
    T temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
