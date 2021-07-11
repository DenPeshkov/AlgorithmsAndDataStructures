package com.github.denpeshkov.datastructures.trees;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MinBinaryHeap<T extends Comparable<? super T>> implements Iterable<T> {
  private T[] arr;
  private int N;

  public MinBinaryHeap() {
    arr = (T[]) new Comparable[4];
    N = 0;
  }

  public MinBinaryHeap(T[] arr) {
    N = arr.length;
    this.arr = (T[]) new Comparable[N + 1];
    System.arraycopy(arr, 0, this.arr, 1, N);
    for (int i = N / 2; i >= 1; i--) sink(i);
  }

  public T getMin() {
    if (isEmpty()) throw new NoSuchElementException();
    return arr[1];
  }

  public T removeMin() {
    if (isEmpty()) throw new NoSuchElementException();
    T min = arr[1];
    exchange(1, N--);
    sink(1);
    arr[N + 1] = null;

    if (N > 0 && N == (arr.length - 1) / 4) resize((arr.length - 1) / 2 + 1);

    return min;
  }

  public void insert(T item) {
    if (N == arr.length - 1) resize(arr.length * 2 - 1);
    arr[++N] = item;
    swim(N);
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  public T remove(int i) {
    // 1-based indexing
    i = i + 1;
    if (i < 1 || i > N) throw new IndexOutOfBoundsException();
    T del = arr[i];
    exchange(i, N--);
    swim(i);
    sink(i);
    arr[N + 1] = null;

    if ((N > 0) && (N == (arr.length - 1) / 4)) resize(N / 2 + 1);

    return del;
  }

  public void changePriority(int i, T item) {
    // 1-based indexing
    i = i + 1;
    if (i < 1 || i > N) throw new IndexOutOfBoundsException();
    arr[i] = item;
    swim(i);
    sink(i);
  }

  @Override
  public Iterator<T> iterator() {
    return new MinBinaryHeapIterator();
  }

  private class MinBinaryHeapIterator implements Iterator<T> {
    private final MinBinaryHeap<T> copy;

    MinBinaryHeapIterator() {
      copy = new MinBinaryHeap<>();
      copy.arr = Arrays.copyOf(arr, arr.length);
      copy.N = N;
    }

    @Override
    public boolean hasNext() {
      return !copy.isEmpty();
    }

    @Override
    public T next() {
      if (!hasNext()) throw new NoSuchElementException();
      return copy.removeMin();
    }
  }

  private void resize(int size) {
    arr = Arrays.copyOf(arr, size);
  }

  private void exchange(int i, int j) {
    T temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  private void swim(int i) {
    while (i > 1 && arr[i].compareTo(arr[i / 2]) < 0) {
      exchange(i, i / 2);
      i = i / 2;
    }
  }

  private void sink(int i) {
    while (2 * i <= N) {
      int min = 2 * i;
      if (min + 1 <= N && arr[min + 1].compareTo(arr[min]) < 0) min = min + 1;
      if (arr[i].compareTo(arr[min]) <= 0) break;
      exchange(i, min);
      i = min;
    }
  }
}
