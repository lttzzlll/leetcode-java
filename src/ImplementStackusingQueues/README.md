### [Implement Stack using Queues](https://leetcode.com/problems/implement-stack-using-queues/description/)

又水了一题.

```Java
class MyStack {
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

}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
```