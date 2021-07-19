package com.github.denpeshkov.datastructures.heap;

public interface Heap<E> extends Iterable<E> {

  void insert(E e);

  E removeMin();

  E remove(int i);

  E getMin();

  void increaseKey(int i, E e);

  void decreaseKey(int i, E e);

  int size();

  boolean isEmpty();
}
