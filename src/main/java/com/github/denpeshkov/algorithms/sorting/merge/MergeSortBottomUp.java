package com.github.denpeshkov.algorithms.sorting.merge;

import com.github.denpeshkov.algorithms.merge.BinaryMerge;

public class MergeSortBottomUp {

  public static <T extends Comparable<? super T>> void sort(T[] arr) {
    T[] aux = (T[]) new Comparable[arr.length];

    for (int sz = 1; sz < arr.length; sz *= 2) {
      for (int lo = 0; lo < arr.length - sz; lo += sz * 2) {
        int mid = lo + sz - 1;
        int hi = Math.min(lo + 2 * sz - 1, arr.length - 1);

        BinaryMerge.merge(arr, aux, lo, mid, hi);
      }
    }
  }
}
