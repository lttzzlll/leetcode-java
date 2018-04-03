### [Pascal's Triangle](https://leetcode.com/problems/pascals-triangle/description/)

> 很简单的题,居然代码又臭又长.

```Java
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>(numRows);
        if (numRows == 0) return list;
        if (numRows == 1) {
            List<Integer> firstline = new LinkedList<>();
            firstline.add(1);
            list.add(firstline);
            return list;
        } else if (numRows == 2) {
            List<Integer> firstline = new LinkedList<>();
            firstline.add(1);
            List<Integer> secondline = new LinkedList<>();
            secondline.add(1);
            secondline.add(1);
            list.add(firstline);
            list.add(secondline);
            return list;
        } else {
            List<Integer> firstline = new LinkedList<>();
            firstline.add(1);
            List<Integer> secondline = new LinkedList<>();
            secondline.add(1);
            secondline.add(1);
            list.add(firstline);
            list.add(secondline);
            for (int i = 3; i <= numRows; i++) {
                List<Integer> curline = new LinkedList<>();
                for (int j = 0; j < list.get(i - 1 - 1).size() - 1; j++) {
                    curline.add(list.get(i - 1 - 1).get(j) + list.get(i - 1- 1).get(j + 1));
                }
                curline.add(0, 1);
                curline.add(1);
                list.add(curline);
            }
            return list;
        }
    }
}
```
