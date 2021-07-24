package com.github.denpeshkov.algorithms.sorting.insertion;

public class InsertionSortSwap {

  public static <T extends Comparable<? super T>> void sort(T[] arr) {
    for (int i = 1; i < arr.length; i++) {
      for (int j = i; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
        exchange(arr, j, j - 1);
      }
    }
  }

  private static <T> void exchange(T[] arr, int i, int j) {
    T temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
