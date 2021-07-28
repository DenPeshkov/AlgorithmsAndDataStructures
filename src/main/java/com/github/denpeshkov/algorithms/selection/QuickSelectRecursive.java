package com.github.denpeshkov.algorithms.selection;

import java.util.concurrent.ThreadLocalRandom;

public class QuickSelectRecursive {

  public static <T extends Comparable<? super T>> T select(T[] arr, int k) {
    if (k < 1 || k > arr.length) {
      throw new IllegalArgumentException();
    }

    // 0-based indexing
    return select(arr, 0, arr.length - 1, k - 1);
  }

  public static <T extends Comparable<? super T>> T select(T[] arr, int lo, int hi, int k) {
    if (lo == hi) {
      return arr[lo];
    }
    int pivot = partition(arr, lo, hi);
    if (k == pivot) {
      return arr[k];
    } else if (k < pivot) {
      return select(arr, lo, pivot - 1, k);
    } else {
      return select(arr, pivot + 1, hi, k);
    }
  }

  private static <T extends Comparable<? super T>> int partition(T[] arr, int lo, int hi) {
    exchange(arr, lo, lo + ThreadLocalRandom.current().nextInt(hi - lo + 1));

    int i = lo, j = hi + 1;
    T v = arr[lo];

    while (true) {
      while (arr[++i].compareTo(v) < 0) {
        if (i == hi) {
          break;
        }
      }
      while (arr[--j].compareTo(v) > 0) {
        if (j == lo) {
          break;
        }
      }
      if (i >= j) {
        break;
      }
      exchange(arr, i, j);
    }
    exchange(arr, lo, j);

    return j;
  }

  private static <T> void exchange(T[] arr, int i, int j) {
    T temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
