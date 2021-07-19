package com.github.denpeshkov.datastructures.priorityqueue;

import com.github.denpeshkov.datastructures.heap.MinBinaryHeap;

import java.util.Iterator;

public class MinPriorityQueue<E extends Comparable<? super E>> implements PriorityQueue<E> {

  private final MinBinaryHeap<E> minBinaryHeap;

  public MinPriorityQueue() {
    minBinaryHeap = new MinBinaryHeap<>();
  }

  public MinPriorityQueue(E[] arr) {
    minBinaryHeap = new MinBinaryHeap<>(arr);
  }

  @Override
  public void insert(E item) {
    minBinaryHeap.insert(item);
  }

  @Override
  public E removeMin() {
    return minBinaryHeap.removeMin();
  }

  @Override
  public E remove(int i) {
    return minBinaryHeap.remove(i);
  }

  @Override
  public E min() {
    return minBinaryHeap.getMin();
  }

  @Override
  public void changeKey(int i, E e) {
    minBinaryHeap.increaseKey(i, e);
    minBinaryHeap.decreaseKey(i, e);
  }

  @Override
  public int size() {
    return minBinaryHeap.size();
  }

  @Override
  public boolean isEmpty() {
    return minBinaryHeap.isEmpty();
  }

  public void merge(MinPriorityQueue<E> priorityQueue) {
    minBinaryHeap.merge(priorityQueue.minBinaryHeap);
  }

  @Override
  public Iterator<E> iterator() {
    return minBinaryHeap.iterator();
  }
}
