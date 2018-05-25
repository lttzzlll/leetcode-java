### [Repeated String Match](https://leetcode.com/problems/repeated-string-match/description/)

从这个题中可以看出leetcode中的超时判定不是针对某一个测试用例,而是针对所有测试用例的
一个大概的时间.通常情况下,leetcode的测试用例的最后一个用例耗时比较长,如果前面耗时太长,
那么很有可能在最后一个测试用例出现,TLE.其原因并不是最后一个测试用例用时太长,
而是前面的测试用例用时太长,给最后测试用例留下的时间太短了.

代码:

```Java
class Solution {
    public int repeatedStringMatch(String A, String B) {
        if (A == B) return 1;
        String s = A;
        for (int i = 1; i <= 10000; i++) {
            if (s.contains(B)) return i;
            if (s.length() > B.length() * 2) break;
            s += A;
        }
        return -1;
    }
}
```

使用最基本的的符合题意的思路就过了.说明leetcode的超时判定并不十分严格.
