package com.github.denpeshkov.algorithms.merge.kway;

import com.github.denpeshkov.datastructures.priorityqueue.MinBinaryHeapPriorityQueue;
import com.github.denpeshkov.datastructures.priorityqueue.PriorityQueue;
import java.util.ArrayList;
import java.util.List;

public class KWayMerge {

  public static <T extends Comparable<? super T>> T[] merge(T[]... arrays) {
    int[] indexes = new int[arrays.length];
    List<T> res = new ArrayList<>();
    PriorityQueue<MinIndPair<T>> priorityQueue = new MinBinaryHeapPriorityQueue<>();

    for (int i = 0; i < arrays.length; i++) {
      if (arrays[i].length > 0) {
        priorityQueue.insert(new MinIndPair<>(i, arrays[i][0]));
      }
    }

    while (!priorityQueue.isEmpty()) {
      MinIndPair<T> minIndPair = priorityQueue.removeMin();
      T min = minIndPair.min;
      int ind = minIndPair.ind;

      res.add(min);
      indexes[ind]++;

      if (indexes[ind] < arrays[ind].length) {
        priorityQueue.insert(new MinIndPair<>(ind, arrays[ind][indexes[ind]]));
      }
    }

    return res.toArray(arrays[0]);
  }

  record MinIndPair<T extends Comparable<? super T>>(int ind, T min)
      implements Comparable<MinIndPair<T>> {

    @Override
    public int compareTo(MinIndPair<T> o) {
      return min.compareTo(o.min);
    }
  }
}
