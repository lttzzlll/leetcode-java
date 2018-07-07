package ImplementStackusingQueues;

import java.util.LinkedList;

/**
 * Created by liutaotao on 2018/7/7.
 */
public class MyStack {
    /**
     * Initialize your data structure here.
     */
    LinkedList<Integer> stack;

    public MyStack() {
        stack = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        stack.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return stack.removeLast();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return stack.getLast();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }
}
