package com.github.denpeshkov.algorithms.merge.kway;

import com.github.denpeshkov.algorithms.merge.binary.BinaryMerge;
import com.github.denpeshkov.datastructures.priorityqueue.MinBinaryHeapPriorityQueue;
import com.github.denpeshkov.datastructures.priorityqueue.PriorityQueue;

public class IterativeOptimalBinaryMerge {

  public static <T extends Comparable<? super T>> T[] merge(T[]... arrays) {
    PriorityQueue<Array<T>> priorityQueue = new MinBinaryHeapPriorityQueue<>();

    for (T[] arr : arrays) {
      priorityQueue.insert(new Array<>(arr));
    }

    while (priorityQueue.size() > 1) {
      Array<T> min1 = priorityQueue.removeMin();
      Array<T> min2 = priorityQueue.removeMin();

      T[] merge = BinaryMerge.merge(min1.arr, min2.arr);

      priorityQueue.insert(new Array<>(merge));
    }

    return priorityQueue.removeMin().arr();
  }

  private static record Array<T>(T[] arr) implements Comparable<Array<T>> {

    @Override
    public int compareTo(Array<T> o) {
      return Integer.compare(arr.length, o.arr.length);
    }
  }
}
