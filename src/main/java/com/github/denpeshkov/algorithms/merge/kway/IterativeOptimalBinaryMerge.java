package com.github.denpeshkov.algorithms.merge.kway;

import com.github.denpeshkov.algorithms.merge.binary.BinaryMerge;
import com.github.denpeshkov.datastructures.queue.ArrayCircularQueue;
import com.github.denpeshkov.datastructures.queue.Queue;
import java.util.Arrays;
import java.util.Comparator;

public class IterativeOptimalBinaryMerge {

  public static <T extends Comparable<? super T>> T[] merge(T[]... arrays) {
    Queue<T[]> lengths1 = new ArrayCircularQueue<>();
    Queue<T[]> lengths2 = new ArrayCircularQueue<>();

    Arrays.sort(arrays, Comparator.comparingInt(arr -> arr.length));

    for (T[] array : arrays) {
      lengths1.enqueue(array);
    }

    while (lengths1.size() + lengths2.size() > 1) {
      T[] min1 = min(lengths1, lengths2);
      T[] min2 = min(lengths1, lengths2);

      T[] merge = BinaryMerge.merge(min1, min2);

      lengths2.enqueue(merge);
    }

    return lengths2.dequeue();
  }

  private static <T> T[] min(Queue<T[]> queue1, Queue<T[]> queue2) {
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

  public static void main(String[] args) {
    Integer[] arr1 = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    Integer[] arr2 =
        new Integer[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    Integer[] arr3 = new Integer[]{3, 3, 3, 100, 103, 143, 145, 670, 899};
    Integer[] arr4 = new Integer[]{};
    Integer[] arr5 = new Integer[]{1, 3, 4};
    Integer[] arr6 = new Integer[]{1000, 1001, 1002};

    System.out.println(Arrays.toString(merge(arr1, arr2, arr3, arr4, arr5, arr6)));
  }
}
