package com.github.denpeshkov.datastructures.adt.priorityqueue;

import com.github.denpeshkov.datastructures.trees.heap.MinBinaryHeap;

public class MinPriorityQueue<T extends Comparable<? super T>> extends MinBinaryHeap<T> {
  public MinPriorityQueue() {
    super();
  }

  public MinPriorityQueue(T[] arr) {
    super(arr);
  }
}
