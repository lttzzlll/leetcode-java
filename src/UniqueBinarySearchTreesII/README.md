### [95. Unique Binary Search Trees II](https://leetcode.com/problems/unique-binary-search-trees-ii/)


```Python
class Solution:
    def generateTrees(self, n):
        """
        :type n: int
        :rtype: List[TreeNode]
        """
        def generate(arr):
            ans = []
            for i in range(len(arr)):
                lefts, rights = generate(arr[:i]), generate(arr[i+1:])
                for l in lefts:
                    for r in rights:
                        root, root.left, root.right = TreeNode(arr[i]), l, r
                        ans.append(root)
            return ans or [None]
        
        return(generate(list(range(1,n+1)))) if n else []

```

这段代码简洁易懂。多加练习。

