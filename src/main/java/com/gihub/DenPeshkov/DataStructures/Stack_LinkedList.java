package com.gihub.DenPeshkov.DataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack_LinkedList<T> implements Iterable<T> {
  private int N = 0;
  private Node<T> first;

  private static class Node<T> {
    private T item;
    private Node<T> next;
  }

  public void push(T item) {
    Node<T> temp = new Node<>();
    temp.item = item;
    temp.next = first;
    first = temp;
    N++;
  }

  public T pop() {
    if (isEmpty()) throw new NoSuchElementException();

    Node<T> node = first;
    first = first.next;
    N--;
    return node.item;
  }

  public boolean isEmpty() {
    return N == 0; // Or first == null
  }

  public int size() {
    return N;
  }

  @Override
  public Iterator<T> iterator() {
    return new StackIterator();
  }

  private class StackIterator implements Iterator<T> {
    private Node<T> node = first;

    @Override
    public boolean hasNext() {
      return node != null;
    }

    @Override
    public T next() {
      if (!hasNext()) throw new NoSuchElementException();

      T item = node.item;
      node = node.next;
      return item;
    }
  }
}
