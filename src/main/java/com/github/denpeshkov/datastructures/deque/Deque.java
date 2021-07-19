package com.github.denpeshkov.datastructures.deque;

public interface Deque<E> extends Iterable<E> {

  void addFirst(E e);

  void addLast(E e);

  E removeFirst();

  E removeLast();

  E first();

  E last();

  int size();

  boolean isEmpty();
}
