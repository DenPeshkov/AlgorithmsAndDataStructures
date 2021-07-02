package com.github.denpeshkov.algorithms.sorting;

public class SelectionSort {
  public static <T extends Comparable<? super T>> void sort(T[] arr) {
    int N = arr.length;
    for (int i = 0; i < N; i++) {
      int min = i;
      for (int j = i + 1; j < N; j++) if (arr[j].compareTo(arr[min]) < 0) min = j;
      exchange(arr, i, min);
    }
  }

  private static <T> void exchange(T[] arr, int i, int j) {
    T temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
