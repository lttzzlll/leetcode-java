package ImplementQueueusingStacks;

import java.util.Stack;

/**
 * Created by liutaotao on 2018/7/7.
 */
public class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        while (!stack1.isEmpty()) stack2.push(stack1.pop());
        int i = stack2.pop();
        while (!stack2.isEmpty()) stack1.push(stack2.pop());
        return i;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        while (!stack1.isEmpty()) stack2.push(stack1.pop());
        int i = stack2.peek();
        while (!stack2.isEmpty()) stack1.push(stack2.pop());
        return i;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack1.isEmpty();
    }
}
