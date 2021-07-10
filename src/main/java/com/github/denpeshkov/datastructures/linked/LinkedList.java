package com.github.denpeshkov.datastructures.linked;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {
  private int N;
  private Node<T> head;
  private Node<T> tail;

  private static class Node<T> {
    T item;
    Node<T> next;

    public Node() {}

    Node(T item, Node<T> next) {
      this.item = item;
      this.next = next;
    }
  }

  public int size() {
    return N;
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public T get(int index) {
    if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();

    return getNode(index).item;
  }

  public T getFirst() {
    if (isEmpty()) throw new NoSuchElementException();
    return head.item;
  }

  public T getLast() {
    if (isEmpty()) throw new NoSuchElementException();
    return tail.item;
  }

  public void addFirst(T item) {
    head = new Node<>(item, head);
    if (tail == null) tail = head;
    N++;
  }

  public void addLast(T item) {
    Node<T> node = new Node<>(item, null);
    if (tail == null) head = tail = node;
    else tail = tail.next = node;
    N++;
  }

  public void add(int index, T item) {
    if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();

    if (index == 0) addFirst(item);
    else if (index == size() - 1) addLast(item);
    else {
      Node<T> node = getNode(index - 1);
      node.next = new Node<>(item, node.next);
    }
    N++;
  }

  public T removeFirst() {
    if (isEmpty()) throw new NoSuchElementException();

    T item = head.item;
    head = head.next;
    if (head == null) tail = null;
    N--;

    return item;
  }

  public T removeLast() {
    if (isEmpty()) throw new NoSuchElementException();

    T item = tail.item;
    if (size() == 1) head = tail = null;
    else {
      Node<T> node = head;
      while (node.next != tail) node = node.next;
      node.next = null;
      tail = node;
    }
    N--;

    return item;
  }

  public T remove(int index) {
    if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();

    T res;

    if (index == 0) res = removeFirst();
    else if (index == size() - 1) res = removeLast();
    else {
      Node<T> node = getNode(index - 1);
      res = node.next.item;
      node.next = node.next.next;
    }
    N--;
    return res;
  }

  public T remove(T item) {
    int i;
    Node<T> node = head;
    for (i = 0; i < size() - 1 && node.next.item != item; i++) node = node.next;
    if (i == size() - 1) throw new NoSuchElementException();
    T res = node.next.item;
    node.next = node.next.next;
    return res;
  }

  public void set(int index, T item) {
    if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();

    Node<T> node = getNode(index);
    node.item = item;
  }

  public void reverse() {
    if (head == null) return;
    Node<T> newHead = head;
    Node<T> node = head.next;

    while (node != null) {
      head.next = node.next;
      node.next = newHead;
      newHead = node;
      node = head.next;
    }
    head = newHead;
    tail = head;
  }

  private Node<T> getNode(int index) {
    Node<T> node = head;
    for (int i = 0; i < index; i++) node = node.next;

    return node;
  }

  @Override
  public Iterator<T> iterator() {
    return new LinkedListIterator();
  }

  private class LinkedListIterator implements Iterator<T> {
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
