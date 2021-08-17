package com.github.denpeshkov.algorithms.sorting.quick;

import java.util.concurrent.ThreadLocalRandom;

public class ThreeWayPartition {

  public static <T extends Comparable<? super T>> Pivot partition(T[] arr, int lo, int hi) {
    swap(arr, lo, lo + ThreadLocalRandom.current().nextInt(hi - lo + 1));

    int pivot_lo = lo, pivot_mid = lo + 1, pivot_hi = hi;
    T v = arr[lo];

    while (pivot_mid <= pivot_hi) {
      int cmp = arr[pivot_mid].compareTo(v);
      if (cmp < 0) {
        swap(arr, pivot_lo++, pivot_mid++);
      } else if (cmp > 0) {
        swap(arr, pivot_mid, pivot_hi--);
      } else {
        pivot_mid++;
      }
    }

    return new Pivot(pivot_lo, pivot_hi);
  }

  public record Pivot(int lo, int hi) {

  }

  private static <T> void swap(T[] arr, int i, int j) {
    T temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
