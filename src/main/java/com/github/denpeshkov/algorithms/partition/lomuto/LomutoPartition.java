package com.github.denpeshkov.algorithms.partition.lomuto;

import java.util.function.Predicate;

public class LomutoPartition {

  public static <T> int partition(T[] arr, Predicate<T> predicate) {
    int i = -1;
    int j = 0;

    for (; j < arr.length; j++) {
      if (predicate.test(arr[j])) {
        swap(arr, ++i, j);
      }
    }

    return i + 1;
  }

  private static <T> void swap(T[] arr, int i, int j) {
    T temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
