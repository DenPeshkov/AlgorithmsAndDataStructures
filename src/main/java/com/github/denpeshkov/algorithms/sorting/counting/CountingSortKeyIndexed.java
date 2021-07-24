package com.github.denpeshkov.algorithms.sorting.counting;

import java.util.function.ToIntFunction;

public class CountingSortKeyIndexed {

  public static <T> void sort(T[] arr, int k, ToIntFunction<T> keyExtractor) {
    int[] counts = new int[k + 1];

    for (T a : arr) {
      counts[keyExtractor.applyAsInt(a)]++;
    }

    for (int i = 1; i < counts.length; i++) {
      counts[i] += counts[i - 1];
    }

    T[] temp = (T[]) new Object[arr.length];

    for (int i = arr.length - 1; i >= 0; i--) {
      temp[counts[keyExtractor.applyAsInt(arr[i])] - 1] = arr[i];
      counts[keyExtractor.applyAsInt(arr[i])]--;
    }

    System.arraycopy(temp, 0, arr, 0, temp.length);
  }
}
