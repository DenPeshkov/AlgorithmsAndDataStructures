package com.github.denpeshkov.datastructures.minstack;

import com.github.denpeshkov.datastructures.stack.ArrayStack;
import com.github.denpeshkov.datastructures.stack.Stack;
import java.util.Iterator;

public class MinStack2Stacks<E extends Comparable<? super E>> implements MinStack<E> {

  private final Stack<E> stack;
  private final Stack<E> minStack;

  public MinStack2Stacks() {
    stack = new ArrayStack<>();
    minStack = new ArrayStack<>();
  }

  @Override
  public E getMin() {
    return minStack.peek();
  }

  @Override
  public void push(E e) {
    stack.push(e);
    E min = minStack.isEmpty() ? e : min(e, getMin());
    minStack.push(min);
  }

  @Override
  public E pop() {
    E res = stack.pop();
    minStack.pop();
    return res;
  }

  @Override
  public E peek() {
    return stack.peek();
  }

  @Override
  public int size() {
    return stack.size();
  }

  @Override
  public boolean isEmpty() {
    return stack.isEmpty();
  }

  @Override
  public Iterator<E> iterator() {
    return stack.iterator();
  }

  private E min(E item1, E item2) {
    return item1.compareTo(item2) <= 0 ? item1 : item2;
  }
}
