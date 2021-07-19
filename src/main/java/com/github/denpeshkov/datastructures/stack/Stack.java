package com.github.denpeshkov.datastructures.stack;

public interface Stack<E> extends Iterable<E> {

  void push(E e);

  E pop();

  E peek();

  int size();

  boolean isEmpty();
}
