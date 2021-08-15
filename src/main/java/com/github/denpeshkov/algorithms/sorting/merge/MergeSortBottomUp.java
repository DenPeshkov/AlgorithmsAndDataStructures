package com.github.denpeshkov.algorithms.sorting.merge;

public class MergeSortBottomUp {

  public static <T extends Comparable<? super T>> void sort(T[] arr) {
    T[] aux = (T[]) new Comparable[arr.length];
    for (int sz = 1; sz < arr.length; sz *= 2) {
      for (int i = 0; i < arr.length - sz; i += sz * 2) {
        MergeSortUtil.merge(arr, aux, i, i + sz - 1, Math.min(i + 2 * sz - 1, arr.length - 1));
      }
    }
  }
}
