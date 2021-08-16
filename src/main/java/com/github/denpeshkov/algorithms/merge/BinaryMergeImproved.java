package com.github.denpeshkov.algorithms.merge;

public class BinaryMergeImproved {

  // a = arr[lo, mid] b = arr[mid+1, hi]
  public static <T extends Comparable<? super T>> void mergeImproved(T[] arr, T[] aux,
      int lo, int mid, int hi) {
    System.arraycopy(arr, lo, aux, 0, mid - lo + 1);

    int i = 0;
    int j = mid + 1;

    for (int k = lo; k <= hi; k++) {
      if (i > mid - lo) {
        break;
      } else if (j > hi) {
        arr[k] = aux[i++];
      } else if (arr[j].compareTo(aux[i]) < 0) {
        arr[k] = arr[j++];
      } else {
        arr[k] = aux[i++];
      }
    }
  }
}
