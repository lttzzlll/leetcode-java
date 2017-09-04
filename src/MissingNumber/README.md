### [Missing Number](https://leetcode.com/problems/missing-number/description/)
> Discuss中有很好的解释.原理同[Single Number](https://leetcode.com/problems/single-number/description/)

| number | 0 | 1 | 2 | 3 | 4 | 6 |
| :-----: | :-----: | :-----: | :-----: | :-----: | :-----: | :-----: |
| position | 0 | 1 | 2 | 3 | 4 | 5 |

> (0 ^ 0) ^ (1 ^ 1) ^ (2 ^ 2) ^ (3 ^ 3) ^ (4 ^ 4) ^ 5 ^ (6 ^ 6) = 0 ^ 5 = 5.
> [Single Number](https://leetcode.com/problems/single-number/description/)看明白了,这道题就明白了.