### [Basic Calculator II](https://leetcode.com/problems/basic-calculator-ii/description/)


展开整个表达式会内存栈溢出.

代码:

```Java
class Solution {
    static boolean isOperator(Character c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }


    static String rem(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        for (Character c : s.toCharArray()) {
            if (c == ' ') continue;
            sb.append(c);
        }
        return sb.toString();
    }

    static List<String> parse(String s) {
        List<String> tokens = new LinkedList<>();
        int lastPos = 0, idx = 0, end = s.length();
        while (idx < end) {
            if (isOperator(s.charAt(idx))) {
                tokens.add(s.substring(lastPos, idx));
                tokens.add(s.substring(idx, idx + 1));
                lastPos = idx + 1;
            }
            idx++;
        }
        if (idx == end) {
            tokens.add(s.substring(lastPos, idx));
        }
        return tokens;
    }

    int fn(Deque<String> deque) {
        String left = deque.removeFirst();
        if (deque.isEmpty()) return Integer.valueOf(left, 10);
        String operator = deque.removeFirst();
        if (operator.equals("+")) {
            return Integer.valueOf(left, 10) + fn(deque);
        } else if (operator.equals("-")) {
            return Integer.valueOf(left, 10) - fn(deque);
        } else if (operator.equals("*")) {
            String right = deque.removeFirst();
            int res = Integer.valueOf(left, 10) * Integer.valueOf(right, 10);
            deque.addFirst(String.valueOf(res));
            return fn(deque);
        } else {
            String right = deque.removeFirst();
            int res = Integer.valueOf(left, 10) / Integer.valueOf(right, 10);
            deque.addFirst(String.valueOf(res));
            return fn(deque);
        }
    }

    public int calculate(String s) {
        String sm = rem(s);
        List<String> tokens = parse(sm);
        Deque<String> deque = new LinkedList<>();
        for (String token : tokens) {
            deque.add(token);
        }
        return fn(deque);
    }

}
```

如何优化?

能不能把递归去掉,替换成迭代?


方案和尾递归优化差不多,用一个栈来代替函数递归.


```Java
class Solution {
    static boolean isOperator(Character c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }


    static String rem(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        for (Character c : s.toCharArray()) {
            if (c == ' ') continue;
            sb.append(c);
        }
        return sb.toString();
    }

    static List<String> parse(String s) {
        List<String> tokens = new LinkedList<>();
        int lastPos = 0, idx = 0, end = s.length();
        while (idx < end) {
            if (isOperator(s.charAt(idx))) {
                tokens.add(s.substring(lastPos, idx));
                tokens.add(s.substring(idx, idx + 1));
                lastPos = idx + 1;
            }
            idx++;
        }
        if (idx == end) {
            tokens.add(s.substring(lastPos, idx));
        }
        return tokens;
    }

    int fn(Deque<String> deque) {
        String left = deque.removeFirst();
        if (deque.isEmpty()) return Integer.valueOf(left, 10);
        String operator = deque.removeFirst();
        if (operator.equals("+")) {
            return Integer.valueOf(left, 10) + fn(deque);
        } else if (operator.equals("-")) {
            return Integer.valueOf(left, 10) - fn(deque);
        } else if (operator.equals("*")) {
            String right = deque.removeFirst();
            int res = Integer.valueOf(left, 10) * Integer.valueOf(right, 10);
            deque.addFirst(String.valueOf(res));
            return fn(deque);
        } else {
            String right = deque.removeFirst();
            int res = Integer.valueOf(left, 10) / Integer.valueOf(right, 10);
            deque.addFirst(String.valueOf(res));
            return fn(deque);
        }
    }

    static boolean isOperator(String op) {
        return op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/");
    }

    int f(Deque<String> deque) {
        Stack<Integer> stack = new Stack<>();
        String op = "+";
        while (!deque.isEmpty()) {
            String s = deque.removeFirst();
            if (isOperator(s)) {
                op = s;
            } else {
                int num = Integer.valueOf(s);
                if (op.equals("+")) {
                    stack.push(num);
                } else if (op.equals("-")) {
                    stack.push(-num);
                } else if (op.equals("*")) {
                    int t = stack.pop();
                    stack.push(t * num);
                } else if (op.equals("/")) {
                    int t = stack.pop();
                    stack.push(t / num);
                }
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public int calculate(String s) {
        String sm = rem(s);
        List<String> tokens = parse(sm);
        Deque<String> deque = new LinkedList<>();
        for (String token : tokens) {
            deque.add(token);
        }
        return f(deque);
    }
}
```


这道题,函数的尾递归可以用栈来优化.用栈来暂存 ***不会立即被消费的元素*** .