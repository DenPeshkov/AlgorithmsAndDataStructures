package com.github.denpeshkov.algorithms.shuffling;

import java.util.concurrent.ThreadLocalRandom;

public class FisherYatesShuffle {

  static <T> void shuffle(T[] arr) {
    int N = arr.length;

    for (int i = 0; i < N; i++) {
      int r = ThreadLocalRandom.current().nextInt(i + 1);
      swap(arr, i, r);
    }
  }

  private static <T> void swap(T[] arr, int i, int j) {
    T t = arr[i];
    arr[i] = arr[j];
    arr[j] = t;
  }
}
