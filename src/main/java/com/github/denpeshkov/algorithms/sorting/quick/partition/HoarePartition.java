package com.github.denpeshkov.algorithms.sorting.quick.partition;

public class HoarePartition {

  public static <T extends Comparable<? super T>> int partition(
      T[] arr, int lo, int hi, int pivot) {
    swap(arr, lo, pivot);

    int i = lo, j = hi + 1;
    T v = arr[lo];

    while (true) {
      while (arr[++i].compareTo(v) < 0) {
        if (i == hi) {
          break;
        }
      }
      while (arr[--j].compareTo(v) > 0) {
        if (j == lo) {
          break;
        }
      }
      if (i >= j) {
        break;
      }
      swap(arr, i, j);
    }

    swap(arr, lo, j);

    return j;
  }

  private static <T> void swap(T[] arr, int i, int j) {
    T temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
