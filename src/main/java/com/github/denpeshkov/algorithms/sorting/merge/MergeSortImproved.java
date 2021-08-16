package com.github.denpeshkov.algorithms.sorting.merge;

import com.github.denpeshkov.algorithms.merge.BinaryMergeImproved;

public class MergeSortImproved {

  public static <T extends Comparable<? super T>> void sort(T[] arr) {
    int aux_len = (int) Math.pow(2, (int) (Math.log(arr.length - 1) / Math.log(2)));
    T[] aux = (T[]) new Comparable[aux_len];

    for (int sz = 1; sz < arr.length; sz *= 2) {
      for (int lo = 0; lo < arr.length - sz; lo += sz * 2) {
        int mid = lo + sz - 1;
        int hi = Math.min(lo + 2 * sz - 1, arr.length - 1);

        System.out.println("a=[" + lo + ", " + mid + "], b=[" + (mid + 1) + ", " + hi + "]");

        if (arr[mid].compareTo(arr[mid + 1]) <= 0) {
          continue;
        }

        BinaryMergeImproved.mergeImproved(arr, aux, lo, mid, hi);
      }
      System.out.println();
    }
  }
}
