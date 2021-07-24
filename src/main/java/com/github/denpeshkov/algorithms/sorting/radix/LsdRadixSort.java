package com.github.denpeshkov.algorithms.sorting.radix;

import java.util.Arrays;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;

public class LsdRadixSort {

  public static <T> void sort(T[] arr, int d, int k, ToIntBiFunction<T, Integer> digitExtractor) {
    int[] counts = new int[k + 1];
    T[] temp = (T[]) new Object[arr.length];

    for (int i = 0; i < d; i++) {
      int finalI = i;
      CountingSortKeyIndexed.sort(arr, counts, temp, a -> digitExtractor.applyAsInt(a, finalI));
    }
  }

  static class CountingSortKeyIndexed {

    private static <T> void sort(T[] arr, int[] counts, T[] temp, ToIntFunction<T> keyExtractor) {
      Arrays.fill(counts, 0);

      for (T a : arr) {
        counts[keyExtractor.applyAsInt(a)]++;
      }

      for (int i = 1; i < counts.length; i++) {
        counts[i] += counts[i - 1];
      }

      for (int i = arr.length - 1; i >= 0; i--) {
        temp[counts[keyExtractor.applyAsInt(arr[i])] - 1] = arr[i];
        counts[keyExtractor.applyAsInt(arr[i])]--;
      }

      System.arraycopy(temp, 0, arr, 0, temp.length);
    }
  }
}
