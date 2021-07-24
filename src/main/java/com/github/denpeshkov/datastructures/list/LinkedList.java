package com.github.denpeshkov.datastructures.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E> {

  private int size;
  private Node<E> head;
  private Node<E> tail;

  public LinkedList() {
    size = 0;
    head = null;
    tail = null;
  }

  public void addFirst(E e) {
    head = new Node<>(e, head);

    if (isEmpty()) {
      tail = head;
    }

    size++;
  }

  public void addLast(E e) {
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
  public void add(int i, E e) {
    if (i < 0 || i >= size) {
      throw new IndexOutOfBoundsException();
    }

    if (i == 0) {
      addFirst(e);
    } else if (i == size - 1) {
      addLast(e);
    } else {
      Node<E> node = getNode(i - 1);
      node.next = new Node<>(e, node.next);
    }

    size++;
  }

  public E removeFirst() {
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

  public E removeLast() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    E old = tail.item;

    if (size == 1) {
      head = tail = null;
    } else {
      Node<E> node = head;
      while (node.next != tail) {
        node = node.next;
      }
      node.next = null;
      tail = node;
    }

    size--;

    return old;
  }

  @Override
  public E remove(int i) {
    if (i < 0 || i >= size) {
      throw new IndexOutOfBoundsException();
    }

    E old;

    if (i == 0) {
      old = removeFirst();
    } else if (i == size - 1) {
      old = removeLast();
    } else {
      Node<E> node = getNode(i - 1);
      old = node.next.item;
      node.next = node.next.next;
    }

    size--;

    return old;
  }

  @Override
  public boolean remove(E e) {
    if (isEmpty()) {
      return false;
    }

    if (head.item == e) {
      removeFirst();
      return true;
    }
    if (tail.item == e) {
      removeLast();
      return true;
    }

    Node<E> node = head;

    while (node.next != null && node.next.item != e) {
      node = node.next;
    }

    if (node.next == null) {
      return false;
    }

    node.next = node.next.next;

    return true;
  }

  public E getFirst() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    return head.item;
  }

  public E getLast() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    return tail.item;
  }

  @Override
  public E get(int i) {
    if (i < 0 || i >= size) {
      throw new IndexOutOfBoundsException();
    }

    return getNode(i).item;
  }

  @Override
  public E setFirst(E e) {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    E old = head.item;
    head.item = e;

    return old;
  }

  @Override
  public E setLast(E e) {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    E old = tail.item;
    tail.item = e;

    return old;
  }

  @Override
  public E set(int i, E e) {
    if (i < 0 || i >= size) {
      throw new IndexOutOfBoundsException();
    }

    Node<E> node = getNode(i);
    E old = node.item;
    node.item = e;

    return old;
  }

  @Override
  public int indexOf(E e) {
    int i;
    Node<E> node = head;

    for (i = 0; i < size && node.item != e; i++) {
      node = node.next;
    }

    if (i == size) {
      return -1;
    }

    return i;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  public void reverse() {
    if (head == null) {
      return;
    }

    Node<E> newHead = head;
    Node<E> node = head.next;

    while (node != null) {
      head.next = node.next;
      node.next = newHead;
      newHead = node;
      node = head.next;
    }

    head = newHead;
    tail = head;
  }

  @Override
  public Iterator<E> iterator() {
    return new LinkedListIterator();
  }

  private Node<E> getNode(int index) {
    Node<E> node = head;
    for (int i = 0; i < index; i++) {
      node = node.next;
    }

    return node;
  }

  private static class Node<E> {

    E item;
    Node<E> next;

    Node(E item, Node<E> next) {
      this.item = item;
      this.next = next;
    }
  }

  private class LinkedListIterator implements Iterator<E> {

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
