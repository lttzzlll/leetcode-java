### [Pascal's Triangle II](https://leetcode.com/problems/pascals-triangle-ii/description/)

理解了这道题,就好理解了,可以理解为就是一道题,然后从两个角度来思考,
会加深对这道题的理解.也会更加明白"缓存","共享"的作用.

代码如下:

```Java
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>(rowIndex);
        for (int i = 0; i < rowIndex + 1; i++) {
            list.add(0, 1);
            for (int j = 1; j < list.size() - 1; j++)
                list.set(j, list.get(j) + list.get(j + 1));
        }
        return list;
    }
}
```

