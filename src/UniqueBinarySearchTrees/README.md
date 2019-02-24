### [Unique Binary Search Trees](https://leetcode.com/problems/unique-binary-search-trees/)


自定而下模式

```python
def f(n):
    if n == 0:
        return 1
    elif n == 1:
        return 1
    elif n == 2:
        return 2
    else:
        r = 0
        for i in range(1, n + 1, 1):
            r += f(i - 1) * f(n - i)
        return r
```

备忘录模式

```python
memo = {}
def f(n):
    if memo.get(n):
        return memo[n]
    if n == 0:
        return 1
    elif n == 1:
        return 1
    elif n == 2:
        return 2
    else:
        r = 0
        for i in range(1, n + 1, 1):
            r += f(i - 1) * f(n - i)
        memo[n] = r
        return r
```

自底而上模式

```python
def f(n):
    memo = [0] * (n + 1)
    memo[0] = memo[1] = 1
    memo[2] = 2
    for i in range(3, n + 1, 1):
        for j in range(1, i + 1, 1):
            memo[i] += memo[j - 1] * memo[i - j]
    return memo[-1]
```

这道题也属于卡特兰数的一种应用。

卡特兰数

```
f(n) = (2*n)! / (n+1)! * n!
```
