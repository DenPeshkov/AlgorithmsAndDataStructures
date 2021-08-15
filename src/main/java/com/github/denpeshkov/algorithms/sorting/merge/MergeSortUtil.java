package com.github.denpeshkov.algorithms.sorting.merge;

public class MergeSortUtil {

  // [lo, mid] [mid+1, hi]
  public static <T extends Comparable<? super T>> void merge(T[] arr, T[] aux,
      int lo, int mid, int hi) {
    System.arraycopy(arr, lo, aux, lo, hi - lo + 1);

    int i = lo;
    int j = mid + 1;

    for (int k = lo; k <= hi; k++) {
      if (i > mid) {
        arr[k] = aux[j++];
      } else if (j > hi) {
        arr[k] = aux[i++];
      } else if (aux[j].compareTo(aux[i]) < 0) {
        arr[k] = aux[j++];
      } else {
        arr[k] = aux[i++];
      }
    }
  }
}
