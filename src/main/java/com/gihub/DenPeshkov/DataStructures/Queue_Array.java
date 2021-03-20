package com.gihub.DenPeshkov.DataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue_Array<T> implements Iterable<T> {
  private T[] arr;
  private int head;
  private int tail;
  private int N;

  public Queue_Array() {
    arr = (T[]) new Object[4];
    head = 0;
    tail = 0;
    N = 0;
  }

  public void enqueue(T item) {
    if (N == arr.length) resize(arr.length * 2);

    arr[tail] = item;
    tail = (tail + 1) % arr.length;

    N++;
  }

  public T dequeue() {
    if (isEmpty()) throw new NoSuchElementException();
    // avoid loitering
    T item = arr[head];
    arr[head] = null;
    head = (head + 1) % arr.length;

    N--;

    if (N > 0 && N == arr.length / 4) resize(arr.length / 2);

    return item;
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  private void resize(int size) {
    T[] temp = (T[]) new Object[size];
    if (head < tail) System.arraycopy(arr, head, temp, 0, N);
    else if (tail < head) {
      System.arraycopy(arr, head, temp, 0, arr.length - head);
      System.arraycopy(arr, 0, temp, arr.length - head, tail);
    }
    head = 0;
    tail = N;

    arr = temp;
  }

  @Override
  public Iterator<T> iterator() {
    return new QueueIterator();
  }

  private class QueueIterator implements Iterator<T> {
    private int i = head;

    @Override
    public boolean hasNext() {
      return i < N;
    }

    @Override
    public T next() {
      if (!hasNext()) throw new NoSuchElementException();
      T item = arr[i];
      i = (i + 1) % arr.length;
      return item;
    }
  }
}
