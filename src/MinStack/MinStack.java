package MinStack;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liutaotao on 2018/5/7.
 */
//public class MinStack {
//    List<Integer> list;
//
//    public MinStack() {
//        list = new LinkedList<>();
//    }
//
//    public void push(int x) {
//        list.add(x);
//    }
//
//    public void pop() {
//        list.remove(list.size() - 1);
//    }
//
//    public int top() {
//        return list.get(list.size() - 1);
//    }
//
//    public int getMin() {
//        Integer minVal = Integer.MAX_VALUE;
//        for (Integer i : list) {
//            if (i < minVal) minVal = i;
//        }
//        return minVal;
//    }
//}

public class MinStack {
    List<Integer> stack;
    List<Integer> min_stack;

    public MinStack() {
        stack = new LinkedList<>();
        min_stack = new LinkedList<>();
    }

    public void push(int x) {
        stack.add(x);
        if (min_stack.isEmpty()) min_stack.add(x);
        else if (x <= min_stack.get(min_stack.size() - 1)) min_stack.add(x);
    }

    public void pop() {
        if (stack.isEmpty()) return;
        int item = stack.remove(stack.size() - 1);
        if (item <= min_stack.get(min_stack.size() - 1)) min_stack.remove(min_stack.size() - 1);
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return min_stack.get(min_stack.size() - 1);
    }
}