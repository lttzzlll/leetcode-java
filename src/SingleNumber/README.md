### [Single Number](https://leetcode.com/problems/single-number/description/)
> Discuss中的解释很好.
> A xor B = B xor A.
> A xor B xor C = A xor (B xor c) = (B xor C) xor A = B xor (C xor A).
> [3, 5, 1, 2, 5, 2, 1]
> 3 ^ 5 ^ 1 ^ 2 ^ 5 ^ 2 ^ 1 = 3 ^ (5 ^ 5) ^ (2 ^ 2) ^ (1 ^ 1) = 3 ^ 0 ^ 0 ^ 0 = 3.
