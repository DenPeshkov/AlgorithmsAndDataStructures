package com.gihub.DenPeshkov.DataStructures;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicArray<T> implements Iterable<T> {
  private T[] arr;
  private int N;

  public DynamicArray() {
    arr = (T[]) new Object[4];
    N = 0;
  }

  public int size() {
    return N;
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public T get(int index) {
    if (index < 0 || index >= N) throw new IndexOutOfBoundsException();
    return arr[index];
  }

  public void set(int index, T item) {
    if (index < 0 || index >= N) throw new IndexOutOfBoundsException();
    arr[index] = item;
  }

  public void add(T item) {
    if (N == arr.length) resize(arr.length * 2);
    arr[N++] = item;
  }

  public void add(int index, T item) {
    if (index < 0 || index >= N) throw new IndexOutOfBoundsException();
    if (N == arr.length) resize(arr.length * 2);
    System.arraycopy(arr, index, arr, index + 1, N - index);
    arr[index] = item;
    N++;
  }

  public T remove(int index) {
    if (index < 0 || index >= N) throw new IndexOutOfBoundsException();
    T item = arr[index];
    // avoid loitering
    arr[N--] = null;
    System.arraycopy(arr, index + 1, arr, index, N - (index + 1));
    if (N > 0 && N == arr.length / 4) resize(arr.length / 2);
    return item;
  }

  public int remove(T item) {
    int index = indexOf(item);
    remove(index);
    return index;
  }

  public int indexOf(T item) {
    if (item == null) {
      for (int i = 0; i < N; i++) if (arr[i] == null) return i;
    } else {
      for (int i = 0; i < N; i++) if (item.equals(arr[i])) return i;
    }

    return -1;
  }

  private void resize(int size) {
    arr = Arrays.copyOf(arr, size);
  }

  @Override
  public Iterator<T> iterator() {
    return new DynamicArrayIterator();
  }

  private class DynamicArrayIterator implements Iterator<T> {
    int i = 0;

    @Override
    public boolean hasNext() {
      return i < N;
    }

    @Override
    public T next() {
      if (!hasNext()) throw new NoSuchElementException();
      return arr[i++];
    }
  }
}
