### [House Robber III](https://leetcode.com/problems/house-robber-iii/)


```python
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def rob(self, root: 'TreeNode') -> 'int':
        max_val = self.f(root)
        return max(max_val)
        
    def f(self, root):
        if not root:
            return [0, 0]

        left_max = self.f(root.left)
        right_max = self.f(root.right)
        max_val = [0, 0]
        # 不包含当前元素的最大值
        max_val[0] = max(left_max) + max(right_max)
        # 包含当前元素的最大值
        max_val[1] = left_max[0] + right_max[0] + root.val
        return max_val

```

这种题型多做几个或许会有更深的体会。
