package com.github.denpeshkov.algorithms.merge.binary;

import java.lang.reflect.Array;

public class BinaryMerge {

  public static <T extends Comparable<? super T>> T[] merge(T[] a, T[] b) {
    T[] res = (T[]) Array.newInstance(a.getClass().getComponentType(), a.length + b.length);

    for (int i = 0, j = 0, k = 0; k < res.length; k++) {
      if (i >= a.length) {
        res[k] = b[j++];
      } else if (j >= b.length) {
        res[k] = a[i++];
      } else if (b[j].compareTo(a[i]) < 0) {
        res[k] = b[j++];
      } else {
        res[k] = a[i++];
      }
    }

    return res;
  }

  // a = arr[lo, mid] b = arr[mid+1, hi]
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
