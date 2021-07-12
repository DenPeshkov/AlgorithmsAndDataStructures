package com.github.denpeshkov.algorithms.selection;

import java.util.concurrent.ThreadLocalRandom;

public class QuickSelect {
  public static <T extends Comparable<? super T>> T select(T[] arr, int k) {
    if (k < 1 || k > arr.length) throw new IllegalArgumentException();

    // 0-based indexing
    k = k - 1;

    int p = 0;
    int r = arr.length - 1;

    while (r > p) {
      int q = partition(arr, p, r);

      if (q < k) p = q + 1;
      else if (q > k) r = q - 1;
      else return arr[k];
    }
    return arr[k];
  }

  private static <T extends Comparable<? super T>> int partition(T[] arr, int p, int r) {
    exchange(arr, p, p + ThreadLocalRandom.current().nextInt(r - p + 1));

    int i = p, j = r + 1;
    T v = arr[p];
    while (true) {
      while (arr[++i].compareTo(v) < 0) if (i == r) break;
      while (arr[--j].compareTo(v) > 0) if (j == p) break;
      if (i >= j) break;
      exchange(arr, i, j);
    }
    exchange(arr, p, j);
    return j;
  }

  private static <T> void exchange(T[] arr, int i, int j) {
    T temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
