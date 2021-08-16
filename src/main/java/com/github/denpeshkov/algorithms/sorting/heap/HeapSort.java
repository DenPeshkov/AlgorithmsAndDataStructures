package com.github.denpeshkov.algorithms.sorting.heap;

public class HeapSort {

  public static <T extends Comparable<? super T>> void sort(T[] arr) {
    int N = arr.length;

    buildMaxHeap(arr);

    while (N > 1) {
      swap(arr, 1, N--);
      sink(arr, 1, N);
    }
  }

  private static <T extends Comparable<? super T>> void buildMaxHeap(T[] arr) {
    for (int i = arr.length / 2; i >= 1; i--) {
      sink(arr, i, arr.length);
    }
  }

  private static <T extends Comparable<? super T>> void sink(T[] arr, int i, int N) {
    while (2 * i <= N) {
      int max = 2 * i;
      if (max + 1 <= N && compare(arr, max, max + 1) < 0) {
        max = max + 1;
      }
      if (compare(arr, i, max) >= 0) {
        break;
      }
      swap(arr, i, max);
      i = max;
    }
  }

  // индексация в массиве с 0
  private static <T extends Comparable<? super T>> int compare(T[] arr, int i, int j) {
    return arr[i - 1].compareTo(arr[j - 1]);
  }

  // индексация в массиве с 0
  private static <T> void swap(T[] arr, int i, int j) {
    T temp = arr[i - 1];
    arr[i - 1] = arr[j - 1];
    arr[j - 1] = temp;
  }
}
