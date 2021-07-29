package com.github.denpeshkov.algorithms.merge;

import java.lang.reflect.Array;

public class Merge {

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
}
