package com.github.denpeshkov.algorithms.sorting.quick;

import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {

  public static <T extends Comparable<? super T>> void sort(T[] arr) {
    sort(arr, 0, arr.length - 1);
  }

  private static <T extends Comparable<? super T>> void sort(T[] arr, int p, int r) {
    if (r <= p) {
      return;
    }
    int q = partition(arr, p, r);
    sort(arr, p, q - 1);
    sort(arr, q + 1, r);
  }

  private static <T extends Comparable<? super T>> int partition(T[] arr, int p, int r) {
    exchange(arr, p, p + ThreadLocalRandom.current().nextInt(r - p + 1));

    int i = p, j = r + 1;
    T v = arr[p];
    while (true) {
      while (arr[++i].compareTo(v) < 0) {
        if (i == r) {
          break;
        }
      }
      while (arr[--j].compareTo(v) > 0) {
        if (j == p) {
          break;
        }
      }
      if (i >= j) {
        break;
      }
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
