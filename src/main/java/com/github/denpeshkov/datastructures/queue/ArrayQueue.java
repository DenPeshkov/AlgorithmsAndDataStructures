package com.github.denpeshkov.datastructures.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue<E> implements Queue<E> {

  private static final int DEFAULT_CAPACITY = 16;

  private E[] arr;
  private int head;
  private int tail;
  private int size;

  public ArrayQueue() {
    arr = (E[]) new Object[DEFAULT_CAPACITY];
    head = 0;
    tail = 0;
    size = 0;
  }

  @Override
  public void enqueue(E e) {
    if (size == arr.length) {
      resize(arr.length * 2);
    }

    arr[tail] = e;
    tail = (tail + 1) % arr.length;

    size++;
  }

  @Override
  public E dequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    E old = arr[head];
    arr[head] = null;
    head = (head + 1) % arr.length;

    size--;

    if (size > 0 && size == arr.length / 4) {
      resize(arr.length / 2);
    }

    return old;
  }

  @Override
  public E peek() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    return arr[head];
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

    int i = head;

    @Override
    public boolean hasNext() {
      return i < size;
    }

    @Override
    public E next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }

      E item = arr[i % arr.length];
      i++;

      return item;
    }
  }

  private void resize(int size) {
    E[] temp = (E[]) new Object[size];

    if (head < tail) {
      System.arraycopy(arr, head, temp, 0, this.size);
    } else if (tail < head) {
      System.arraycopy(arr, head, temp, 0, arr.length - head);
      System.arraycopy(arr, 0, temp, arr.length - head, tail);
    }

    head = 0;
    tail = this.size;
    arr = temp;
  }
}
