package com.github.denpeshkov.algorithms.partition;

import java.util.function.Predicate;

public class HoarePartition {

  public static <T> int partition(T[] arr, Predicate<T> predicate) {
    int i = 0, j = arr.length;

    while (true) {
      while (predicate.test(arr[++i])) {
        if (i == arr.length - 1) {
          break;
        }
      }
      while (!predicate.test(arr[--j])) {
        if (j == 0) {
          break;
        }
      }
      if (i >= j) {
        break;
      }
      swap(arr, i, j);
    }

    swap(arr, 0, j);

    return j;
  }

  private static <T> void swap(T[] arr, int i, int j) {
    T temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
