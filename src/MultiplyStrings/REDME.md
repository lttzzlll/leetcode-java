### [43. Multiply Strings](https://leetcode.com/problems/multiply-strings/)


```Python
class Solution:
    def multiply(self, num1, num2):
        a, b = 0, 0
        for c in num1:
            a = a * 10 + c
        for c in num2:
            b = b * 10 + c
        
```