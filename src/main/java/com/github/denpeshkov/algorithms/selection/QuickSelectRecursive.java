package com.github.denpeshkov.algorithms.selection;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSelectRecursive {
  public static <T extends Comparable<? super T>> T select(T[] arr, int k) {
    if (k < 1 || k > arr.length) throw new IllegalArgumentException();

    // 0-based indexing
    return select(arr, 0, arr.length - 1, k - 1);
  }

  public static <T extends Comparable<? super T>> T select(T[] arr, int p, int r, int k) {
    if (p == r) return arr[p];
    int q = partition(arr, p, r);
    if (k == q) return arr[k];
    else if (k < q) return select(arr, p, q - 1, k);
    else return select(arr, q + 1, r, k);
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
