package com.github.denpeshkov.datastructures.heap;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MinBinaryHeap<E extends Comparable<? super E>> implements Heap<E> {

  private static final int DEFAULT_CAPACITY = 16;

  private E[] arr;
  private int size;

  public MinBinaryHeap() {
    arr = (E[]) new Comparable[DEFAULT_CAPACITY];
    size = 0;
  }

  public MinBinaryHeap(E[] keys) {
    size = keys.length;
    this.arr = (E[]) new Comparable[size + 1];

    System.arraycopy(keys, 0, this.arr, 1, size);

    for (int i = size / 2; i >= 1; i--) {
      sink(i);
    }
  }

  @Override
  public void insert(E e) {
    if (size == arr.length - 1) {
      resize(arr.length * 2 - 1);
    }

    arr[++size] = e;
    swim(size);
  }

  @Override
  public E removeMin() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    E min = arr[1];

    exchange(1, size--);
    sink(1);
    arr[size + 1] = null;

    if (size > 0 && size == (arr.length - 1) / 4) {
      resize((arr.length - 1) / 2 + 1);
    }

    return min;
  }

  @Override
  public E remove(int i) {
    // 1-based indexing
    i = i + 1;

    if (i < 1 || i > size) {
      throw new IndexOutOfBoundsException();
    }

    E old = arr[i];
    exchange(i, size--);
    swim(i);
    sink(i);
    arr[size + 1] = null;

    if ((size > 0) && (size == (arr.length - 1) / 4)) {
      resize(size / 2 + 1);
    }

    return old;
  }

  @Override
  public E getMin() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    return arr[1];
  }

  @Override
  public void increaseKey(int i, E e) {
    // 1-based indexing
    i = i + 1;

    if (i < 1 || i > size) {
      throw new IndexOutOfBoundsException();
    }

    if (arr[i].compareTo(e) == 0 || arr[i].compareTo(e) > 0) {
      return;
    }

    arr[i] = e;
    sink(i);
  }

  @Override
  public void decreaseKey(int i, E e) {
    // 1-based indexing
    i = i + 1;

    if (i < 1 || i > size) {
      throw new IndexOutOfBoundsException();
    }

    if (arr[i].compareTo(e) == 0 || arr[i].compareTo(e) < 0) {
      return;
    }

    arr[i] = e;
    swim(i);
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  public void merge(MinBinaryHeap<E> heap) {
    arr = Arrays.copyOf(arr, arr.length + heap.size());
    System.arraycopy(heap.arr, 1, arr, size + 1, heap.size());

    size = arr.length - 1;

    for (int i = size / 2; i >= 1; i--) {
      sink(i);
    }
  }

  @Override
  public Iterator<E> iterator() {
    return new MinBinaryHeapIterator();
  }

  private void resize(int size) {
    arr = Arrays.copyOf(arr, size);
  }

  private void exchange(int i, int j) {
    E temp = arr[i];
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
    while (2 * i <= size) {
      int min = 2 * i;
      if (2 * i + 1 <= size && arr[2 * i + 1].compareTo(arr[min]) < 0) {
        min = 2 * i + 1;
      }
      if (arr[i].compareTo(arr[min]) <= 0) {
        break;
      }
      exchange(i, min);
      i = min;
    }
  }

  private class MinBinaryHeapIterator implements Iterator<E> {

    final MinBinaryHeap<E> copy;

    MinBinaryHeapIterator() {
      copy = new MinBinaryHeap<>();
      copy.arr = Arrays.copyOf(arr, arr.length);
      copy.size = size;
    }

    @Override
    public boolean hasNext() {
      return !copy.isEmpty();
    }

    @Override
    public E next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }

      return copy.removeMin();
    }
  }
}
