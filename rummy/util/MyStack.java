/* Joshua Alberty
 * 801-18-3932
 * CCOM 4029-002
 * Prof. Ordonez
 */

package rummy.util;

import java.util.*;

/*
 * Basic stack ADT implemented from scratch. Contains the typical stack methods:
 * pop(), push(), peek(), isEmpty() and size(). It also has extra methods: isFull(),
 * and peek().
 */

public class MyStack<S> {
  // Instance attributes.
  final private List<S> stack;
  final private int capacity;

  
  // Creates an empty stack with capacity given by the parameter size.
  public MyStack(int size) {
    stack = new ArrayList<S>(size);
    capacity = size;
  } 
 
  // Returns true if the stack is empty, otherwise returns false.
  public boolean isEmpty() {
	return stack.isEmpty();
  }

  // Returns true if the stack is full, otherwise returns false.
  public boolean isFull() {
    return stack.size() == capacity;
  }

  // Inserts an element into the top of the stack. 
  public void push(S p) {
    if (isFull()) {
      System.out.println("Stack is already full. Exiting.");
      return;
    }
    stack.add(p);
  }

  /* Removes the element at the top of the stack, if the stack isn't empty. 
   * If the stack is empty, return null.
   */
  public S pop() {
    if (isEmpty()) {
      System.out.println("Stack is already empty. Exiting.");
      return null;
    }

    int size = stack.size();
    S topElement = stack.get(size - 1);
    stack.remove(size - 1);
    return topElement;
  }

  /* Returns the element at the top of the stack without removing it, if the stack isn't empty.
   * If the stack is empty, return null.
   */
  public S peek() {
    if (isEmpty()) {
      return null;
    }

    int size = stack.size();
    return stack.get(size - 1);
  }

}