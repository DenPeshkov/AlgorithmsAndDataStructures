package com.github.denpeshkov.datastructures.adt.priorityqueue;

import com.github.denpeshkov.datastructures.trees.heap.MinBinaryHeap;

import java.util.Iterator;

public class MinPriorityQueue<T extends Comparable<? super T>> implements Iterable<T> {
  private final MinBinaryHeap<T> minBinaryHeap;

  public MinPriorityQueue() {
    minBinaryHeap = new MinBinaryHeap<>();
  }

  public MinPriorityQueue(T[] arr) {
    minBinaryHeap = new MinBinaryHeap<>(arr);
  }

  public T getMin() {
    return minBinaryHeap.getMin();
  }

  public T removeMin() {
    return minBinaryHeap.removeMin();
  }

  public void insert(T item) {
    minBinaryHeap.insert(item);
  }

  public boolean isEmpty() {
    return minBinaryHeap.isEmpty();
  }

  public int size() {
    return minBinaryHeap.size();
  }

  public T remove(int i) {
    return minBinaryHeap.remove(i);
  }

  public void changePriority(int i, T item) {
    minBinaryHeap.changePriority(i, item);
  }

  public void decreaseKey(int i, T item) {
    minBinaryHeap.decreaseKey(i, item);
  }

  public void increaseKey(int i, T item) {
    minBinaryHeap.increaseKey(i, item);
  }

  public void merge(MinBinaryHeap<T> heap) {
    minBinaryHeap.merge(heap);
  }

  @Override
  public Iterator<T> iterator() {
    return minBinaryHeap.iterator();
  }
}
