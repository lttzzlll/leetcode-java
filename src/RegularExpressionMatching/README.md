### regular expression
1. using the Regular expression module
2. using dynamic programming
3. using recursive

### USING Recursive
> 使用递归算法
> 这个问题应用递归算法还是比较容易理解的,但是该递归算法的时间复杂度绝对不是O(n),
> 因为其中的一个分支可能会同时进行.该时间复杂度需要再考虑一下.

> 无论使用哪种算法,各种条件都必须要找全,即在何种条件下应该做什么,这个工作只能手工实验,
> 很难一下把所有的边界条件找全.

### Dynamic Programming
> 用一张表来记录结果

T[i][j] = true if s[0, i) matches p[0, j)

T[i][j] = T[i - 1][j - 1] if s[i] == p[j] or p[j] == '.'

T[i][j] = T[i][j - 2] if p[j - 1] == '*'

T[i][j] = T[i - 1][j] if p[j - 1] = '*' and s[i - 1] == p[j - 2] || p[j - 2] == '.'

T[0][0] = true