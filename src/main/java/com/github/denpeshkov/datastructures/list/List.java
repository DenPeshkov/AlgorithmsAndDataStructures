package com.github.denpeshkov.datastructures.list;

public interface List<E> extends Iterable<E> {

  void addFirst(E e);

  void addLast(E e);

  void add(int i, E e);

  E removeFirst();

  E removeLast();

  E remove(int i);

  boolean remove(E e);

  E getFirst();

  E getLast();

  E get(int i);

  E setFirst(E e);

  E setLast(E e);

  E set(int i, E e);

  int indexOf(E e);

  int size();

  boolean isEmpty();
}
