package com.github.denpeshkov.datastructures.minstack;

import com.github.denpeshkov.datastructures.stack.Stack;

public interface MinStack<E> extends Stack<E> {

  E getMin();
}
