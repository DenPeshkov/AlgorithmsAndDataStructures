package com.gihub.DenPeshkov.DataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<T> implements Iterable<T> {
  private T[] arr;
  private int N;

  public Stack() {
    arr = (T[]) new Object[4];
    N = 0;
  }

  public void push(T item) {
    if (N == arr.length) resize(arr.length * 2);
    arr[N++] = item;
  }

  public T pop() {
    if (isEmpty()) throw new NoSuchElementException();
    // avoid loitering
    T item = arr[--N];
    arr[N] = null;
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
    System.arraycopy(arr, 0, temp, 0, arr.length);
    arr = temp;
  }

  @Override
  public Iterator<T> iterator() {
    return new StackIterator();
  }

  private class StackIterator implements Iterator<T> {
    private int i = N;

    @Override
    public boolean hasNext() {
      return i > 0;
    }

    @Override
    public T next() {
      return arr[--i];
    }
  }
}
