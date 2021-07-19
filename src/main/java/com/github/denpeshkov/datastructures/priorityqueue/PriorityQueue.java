package com.github.denpeshkov.datastructures.priorityqueue;

public interface PriorityQueue<E> extends Iterable<E> {

  void insert(E e);

  E removeMin();

  E remove(int i);

  E getMin();

  void changeKey(int i, E e);

  int size();

  boolean isEmpty();
}
