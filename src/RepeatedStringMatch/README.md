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

其中最重要的一个地方是提前终止的条件

```Java
if (s.length() > B.length() * 2) break;
```

因为在 s.length() >= B.length() * 2 的情况下, 如果 B not in s, 则 B not in s + A. 分类讨论.

1). A.length() > B.length():

A = abbc, B = bca. 则 B in A * 2 = abbcabbc > B.length() * 2.

2) A.length() < B.length()

A = abc, B = bcabc. 则 B in A * 3 = abcabcabc > B.length() * 2.

3) A.length() = B.length()

A = abc, B = bca. 则 B in A * 2 = abcabc = B.length() * 2.

在, s.length() >= B.length() * 2 的情况下, 如果 B in c.则一定存在于 A * (2 or 3) 的序列中.

如果 B 不在 s 中, 则无论s如何增长,都无法满足条件.