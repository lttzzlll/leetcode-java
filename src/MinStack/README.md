### [Min Stack](https://leetcode.com/problems/min-stack/description/)

这道题要干啥?

Naive的方法:

```Java
class MinStack {

    List<Integer> list;

    public MinStack() {
        list = new LinkedList<>();
    }

    public void push(int x) {
        list.add(x);
    }

    public void pop() {
        list.remove(list.size() - 1);
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        Integer minVal = Integer.MAX_VALUE;
        for (Integer i : list) {
            if (i < minVal) minVal = i;
        }
        return minVal;
    }
}
```

正确的解法是在栈之外保存一个 **增量记录**, 记录当前时刻栈内的最小值.同时,这个 **增量记录**是可以压缩的.

```Java
class MinStack {
    List<Integer> stack;
    List<Integer> min_stack;

    public MinStack() {
        stack = new LinkedList<>();
        min_stack = new LinkedList<>();
    }

    public void push(int x) {
        stack.add(x);
        if (min_stack.isEmpty()) min_stack.add(x);
        else min_stack.add(Integer.min(x, min_stack.get(min_stack.size() - 1)));
    }

    public void pop() {
        if (stack.isEmpty()) return;
        stack.remove(stack.size() - 1);
        min_stack.remove(min_stack.size() - 1);
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return min_stack.get(min_stack.size() - 1);
    }
}
```

压缩 **增量记录**

```
    index: 0 1 2 3 4 5 6 7 8 9
    stack: 5 3 8 4 5 2 6 7 9 8
min_stack: 5 3 3 3 3 2 2 2 2 2
```

观察到, min_stack 中存在连续且重复的记录,可以将连续且重复的记录压缩为一个不重复的序列 ```5 3 2```

1. 每次push的时候,判断新插入的值是否小于min_stack中的当前值,如果小于,则将改值加入min_stack中;
否则,不加入.

2. 每次pop的时候,判断stack中pop出来的值是否大于min_stack当前值,如果大于,min_stack不弹出值;
否则,min_stack弹出当前最小值.

3. 每次getMin的时候,直接返回min_stack中当前最小值.

上述为大题思路,细节还需注意.


```Java
class MinStack {
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
```


```
    index: 0 1 2 3 4 5 6 7 8 9 10
    stack: 5 3 8 4 5 2 6 7 9 8 2
min_stack: 5 3 - - - 2 - - - - 2  # only 4 items
```

- 线为左侧值向右延展

注意: 在压缩 **增量记录** 的算法中, 如果前后push的两个值大小一致,则这两个值都会push到min_stack中.
