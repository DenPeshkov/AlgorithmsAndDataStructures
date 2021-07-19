package com.github.denpeshkov.datastructures.queue;

public interface Queue<E> extends Iterable<E> {

  void enqueue(E e);

  E dequeue();

  E peek();

  int size();

  boolean isEmpty();
}
