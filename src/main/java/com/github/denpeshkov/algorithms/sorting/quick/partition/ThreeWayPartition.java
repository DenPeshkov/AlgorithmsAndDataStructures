package com.github.denpeshkov.algorithms.sorting.quick.partition;

public class ThreeWayPartition {

  public static <T extends Comparable<? super T>> Pivots partition(
      T[] arr, int lo, int hi, int pivot) {
    swap(arr, lo, pivot);

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

    return new Pivots(pivot_lo, pivot_hi);
  }

  private static <T> void swap(T[] arr, int i, int j) {
    T temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public record Pivots(int lo, int hi) {

  }
}
