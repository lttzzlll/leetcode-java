### [Length of Last Word](https://leetcode.com/problems/length-of-last-word/description/)

> Easy的题就是无聊,增加一下编程的经验.还是比不上Discuss中给出的方法简洁.

```Java
public int lengthOfLastWord(String s) {
    return s.trim().length()-s.trim().lastIndexOf(" ")-1;
}
```

```
[0] "Hello World "
[1] s.trim().length = 11
[2] s.trim().lastIndexOf(" ") = 5
[3] s.trim().length - s.trim().lastIndexOf(" ") - 1 = 11 - 5 - 1 = 5
```

实际上还是两个字符串求差.上面是一般情况,特殊情况下如"a "也是成立的.