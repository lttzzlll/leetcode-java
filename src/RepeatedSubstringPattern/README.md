### [Repeated Substring Pattern](https://leetcode.com/problems/repeated-substring-pattern/description/)


水题,按照题意即可,从切割的分数开始,2,3,4...
其中任意一种可以被切分,则返回true;全部不满足,返回false;

代码:

```Java
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int i = 2; i <= len; i++) {
            if (len % i == 0) {
                int step = len / i;
                boolean flag = true;
                for (int j = step; j < len; j += step) {
                    if (!s.substring(j - step, j).equals(s.substring(j, j + step))) {
                        flag = false;
                        break;
                    }
                }
                if (flag) return true;
            }
        }
        return false;
    }
}
```