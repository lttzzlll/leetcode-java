### [Longest Valid Parentheses](https://leetcode.com/problems/longest-valid-parentheses/description/)

两个思路,一个是用栈,用一种方法是动态规划.

这个栈是用来存储字符串中的"奇异点"的.所谓的"奇异点",就是字符串中
哪些不能匹配的点.如下:

```
( ) ( ) ) ( ) ( )
0 1 2 3 4 5 6 7 8
```

其中,位置4就叫做"奇异点",因为该点的存在,原字符串被分割为左右"不连续"两部分,
所谓的"最大长度"就是从左右两部分中找出最大的.所以这个栈就是用来存储这些"奇异点"的,
而所谓的"最大长度"则可以通过左右两边字符串边界求差得出.

由此可得代码如下:

```
class Solution {
 public int longestValidParentheses(String s) {
        int len = s.length(), maxLen = 0;
        char[] arr = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (arr[i] == '(') stack.push(i);
            else {
                if (!stack.isEmpty()) {
                    if (arr[stack.peek()] == '(') stack.pop();
                    else stack.push(i);
                } else stack.push(i);
            }
        }
        if (stack.empty()) maxLen = len;
        else {
            int a = len, b = 0;
            while (!stack.empty()) {
                b = stack.pop();
                maxLen = Math.max(maxLen, a - b - 1);
                a = b;
            }
            maxLen = Math.max(maxLen, a - 0);
        }
        return maxLen;
    }
}
```

注意这一行

```
maxLen = Math.max(maxLen, a - 0);
```

当字符串如下时:

```
( ) ( ) ( ) ) ( ) ( )
0 1 2 3 4 5 6 7 8 9 10
```

此时:

```
a = 11
b = 6

a - b - 1 = 4

a = b = 6

maxLen = Math.max(maxLen, a - 0) = max(4, 6) = 6
```

由此可以理解.


另一种思路-动态规划:
[https://www.yalewoo.com/oj_leetcode_32_longest_valid_parentheses.html](https://www.yalewoo.com/oj_leetcode_32_longest_valid_parentheses.html)
这里有很好的解释,大致示意如下:

s - 表示括号字符串
dp - 表示用来存储能够匹配的括号字符串子串的最大长度
i - 表示下标

情况1: s[i] == '(', s[i]不与s[i]之前的任何括号子串匹配, 则 dp[i] = 0. (i > 1)

情况2: s[i] == ')',

       s[i - 1] == '(', s[i]匹配s[i-1], 则 dp[i] = dp[i - 2] + 2. (i > 1)
       s[i - 1] == ')', s[i]不匹配s[i-1],则跳过s[i-1],观察以s[i-1]结尾的子串之前的子串,
       看看是否存在s[i - dp[i - 1] - 1] == '(', 从而匹配 s[i].
       如果匹配, 则有 dp[i] = dp[i - dp[i - 1] - 2] + 1 + dp[i - 1] + 1;
       如果不匹配,则有 dp[i] = 0.

作者给出的图示更加清楚.

代码如下:

```
class Solution {
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        s = ')' + s;
        int[] dp = new int[s.length()];
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == '(') dp[i] = 0;
            else { // s[i] = ')'
                if (s.charAt(i - 1) == '(') dp[i] = dp[i - 2] + 2;
                else { // s[i - 1] = ')'
                    if (s.charAt(i - dp[i - 1] - 1) == '(') dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
                    else dp[i] = 0;
                }
            }
            if (dp[i] > maxLen) maxLen = dp[i];
        }
        return maxLen;
    }
}
```



比如括号串 '()())(())',如下:

-------------------------------------
| ( | ) | ( | ) | ) | ( | ( | ) | ) |
-------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |
-------------------------------------

添加一个哑结点后

-----------------------------------------
| ) | ( | ) | ( | ) | ) | ( | ( | ) | ) |
-----------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------
| 0 | 0 | 2 | 0 | 4 | 4 | 0 | 0 | 2 | 4 |
-----------------------------------------

按照如上的算法,所以最长子串为4.





