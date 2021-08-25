package com.github.denpeshkov.algorithms.selection;

import com.github.denpeshkov.algorithms.sorting.quick.partition.HoarePartition;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSelect {

  public static <T extends Comparable<? super T>> T select(T[] arr, int k) {
    if (k < 1 || k > arr.length) {
      throw new IllegalArgumentException();
    }

    // 0-based indexing
    k = k - 1;

    int lo = 0;
    int hi = arr.length - 1;

    while (hi > lo) {
      int pivot = lo + ThreadLocalRandom.current().nextInt(hi - lo + 1);

      pivot = HoarePartition.partition(arr, lo, hi, pivot);

      if (pivot < k) {
        lo = pivot + 1;
      } else if (pivot > k) {
        hi = pivot - 1;
      } else {
        return arr[k];
      }
    }

    return arr[k];
  }
}
