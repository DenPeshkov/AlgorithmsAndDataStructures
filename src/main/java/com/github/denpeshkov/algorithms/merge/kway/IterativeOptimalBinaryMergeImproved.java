package com.github.denpeshkov.algorithms.merge.kway;

import com.github.denpeshkov.algorithms.merge.binary.BinaryMerge;
import com.github.denpeshkov.algorithms.sorting.radix.LsdRadixSort;
import com.github.denpeshkov.datastructures.queue.ArrayCircularQueue;
import com.github.denpeshkov.datastructures.queue.Queue;

public class IterativeOptimalBinaryMergeImproved {

  public static <T extends Comparable<? super T>> T[] merge(T[]... arrays) {
    Queue<T[]> lengths1 = new ArrayCircularQueue<>();
    Queue<T[]> lengths2 = new ArrayCircularQueue<>();

    int d = 0;

    for (T[] array : arrays) {
      d = Math.max(d, array.length);
    }

    LsdRadixSort.sort(arrays, d, 9, (arr, i) -> ((int) (arr.length / Math.pow(10, i)) % 10));

    for (T[] array : arrays) {
      lengths1.enqueue(array);
    }

    while (lengths1.size() + lengths2.size() > 1) {
      T[] min1 = dequeueMin(lengths1, lengths2);
      T[] min2 = dequeueMin(lengths1, lengths2);

      T[] merge = BinaryMerge.merge(min1, min2);

      lengths2.enqueue(merge);
    }

    return lengths2.dequeue();
  }

  private static <T> T[] dequeueMin(Queue<T[]> queue1, Queue<T[]> queue2) {
    T[] min;

    if (queue1.isEmpty()) {
      min = queue2.dequeue();
    } else if (queue2.isEmpty()) {
      min = queue1.dequeue();
    } else if (queue1.peek().length <= queue2.peek().length) {
      min = queue1.dequeue();
    } else {
      min = queue2.dequeue();
    }

    return min;
  }
}
