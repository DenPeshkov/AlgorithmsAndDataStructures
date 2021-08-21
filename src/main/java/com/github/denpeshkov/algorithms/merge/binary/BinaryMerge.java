package com.github.denpeshkov.algorithms.merge.binary;

import java.util.ArrayList;
import java.util.List;

public class BinaryMerge {

  public static <T extends Comparable<? super T>> T[] merge(T[] a, T[] b) {
    int N = a.length + b.length;

    List<T> res = new ArrayList<>(N);

    for (int i = 0, j = 0, k = 0; k < N; k++) {
      if (i >= a.length) {
        res.add(b[j++]);
      } else if (j >= b.length) {
        res.add(a[i++]);
      } else if (b[j].compareTo(a[i]) < 0) {
        res.add(b[j++]);
      } else {
        res.add(a[i++]);
      }
    }

    return res.toArray(a);
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
