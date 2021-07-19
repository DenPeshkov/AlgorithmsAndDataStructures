package com.github.denpeshkov.datastructures.deque;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayDeque<E> implements Deque<E> {

  private static final int DEFAULT_CAPACITY = 16;

  private E[] arr;
  private int head;
  private int tail;
  private int size;

  public ArrayDeque() {
    arr = (E[]) new Object[DEFAULT_CAPACITY];
    head = 0;
    tail = 0;
    size = 0;
  }

  @Override
  public void addFirst(E e) {
    if (size == arr.length) {
      resize(arr.length * 2);
    }

    head = (head - 1 + arr.length) % arr.length;
    arr[head] = e;

    size++;
  }

  @Override
  public void addLast(E e) {
    if (size == arr.length) {
      resize(arr.length * 2);
    }

    arr[tail] = e;
    tail = (tail + 1) % arr.length;

    size++;
  }

  @Override
  public E removeFirst() {
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
  public E removeLast() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    tail = (tail - 1 + arr.length) % arr.length;

    E old = arr[tail];
    arr[tail] = null;

    size--;

    if (size > 0 && size == arr.length / 4) {
      resize(arr.length / 2);
    }

    return old;
  }

  @Override
  public E first() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    return arr[head];
  }

  @Override
  public E last() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    return arr[tail - 1];
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
    return new DequeIterator();
  }

  private class DequeIterator implements Iterator<E> {

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

      E temp = arr[i % arr.length];
      i++;

      return temp;
    }
  }

  private void resize(int newSize) {
    E[] temp = (E[]) new Object[newSize];

    if (tail > head) {
      System.arraycopy(arr, head, temp, 0, tail - head);
      tail -= head;
    } else {
      System.arraycopy(arr, head, temp, 0, arr.length - head);
      System.arraycopy(arr, 0, temp, arr.length - head, tail);
      tail += arr.length - head;
    }

    head = 0;
    arr = temp;
  }
}
