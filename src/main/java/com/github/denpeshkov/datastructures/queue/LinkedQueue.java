package com.github.denpeshkov.datastructures.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<E> implements Queue<E> {

  private Node<E> head;
  private Node<E> tail;
  private int size;

  public LinkedQueue() {
    head = null;
    tail = null;
    size = 0;
  }

  private static class Node<T> {

    T item;
    Node<T> next;

    Node(T item, Node<T> next) {
      this.item = item;
      this.next = next;
    }
  }

  @Override
  public void enqueue(E e) {
    Node<E> node = new Node<>(e, null);

    if (isEmpty()) {
      head = node;
    } else {
      tail.next = node;
    }
    tail = node;
    size++;
  }

  @Override
  public E dequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    E old = head.item;
    head = head.next;

    size--;

    if (isEmpty()) {
      tail = null;
    }

    return old;
  }

  @Override
  public E peek() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    return head.item;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public Iterator<E> iterator() {
    return new QueueIterator();
  }

  private class QueueIterator implements Iterator<E> {

    Node<E> node = head;

    @Override
    public boolean hasNext() {
      return node != null;
    }

    @Override
    public E next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }

      E item = node.item;
      node = node.next;

      return item;
    }
  }
}
