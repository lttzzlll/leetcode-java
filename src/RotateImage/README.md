### [Rotate Image](https://leetcode.com/problems/rotate-image/description/)

> 图片旋转.

> 先以横轴为对称线做一次上下变换,然后再以斜对角线为对称线做一次变换.

```
0.

1 2 3
4 5 6
7 8 9

1.

7 8 9
4 5 6
1 2 3

2.

7 4 1
8 5 2
9 6 3
```

> 但是,为什么要这样做变换?