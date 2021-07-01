package com.gihub.DenPeshkov.DataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue_LinkedList<T> implements Iterable<T> {
  private Node<T> head;
  private Node<T> tail;
  private int N = 0;

  private static class Node<T> {
    private T item;
    private Node<T> next;
  }

  public void enqueue(T item) {
    Node<T> node = new Node<>();
    node.item = item;
    node.next = null;
    if (isEmpty()) head = tail;
    else tail.next = node;
    tail = node;
    N++;
  }

  public T dequeue() {
    if (isEmpty()) throw new NoSuchElementException();
    Node<T> node = head;
    head = head.next;
    N--;
    if (isEmpty()) tail = null;
    return node.item;
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  @Override
  public Iterator<T> iterator() {
    return new QueueIterator();
  }

  private class QueueIterator implements Iterator<T> {
    private Node<T> node = head;

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
