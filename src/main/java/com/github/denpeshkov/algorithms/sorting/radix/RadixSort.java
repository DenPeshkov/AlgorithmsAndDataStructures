package com.github.denpeshkov.algorithms.sorting.radix;

import com.github.denpeshkov.algorithms.sorting.counting.CountingSortKeyIndexed;
import java.util.function.ToIntBiFunction;

public class RadixSort {

  public static <T> void sort(T[] arr, int d, int k, ToIntBiFunction<T, Integer> digitExtractor) {
    for (int i = 0; i < d; i++) {
      int finalI = i;
      CountingSortKeyIndexed.sort(arr, k, a -> digitExtractor.applyAsInt(a, finalI));
    }
  }
}
