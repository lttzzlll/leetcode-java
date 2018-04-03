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

简化后的代码:

```Java
class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>(numRows);
        if (numRows > 0) {
            List<Integer> firstLine = new LinkedList<>();
            firstLine.add(1);
            list.add(firstLine);
            if (numRows > 1) {
                List<Integer> secondLine = new LinkedList<>();
                secondLine.add(1);
                secondLine.add(1);
                list.add(secondLine);
                if (numRows > 2) {
                    for (int i = 3; i <= numRows; i++) {
                        List<Integer> curLine = new LinkedList<>();
                        for (int j = 0; j < list.get(i - 1 - 1).size() - 1; j++) {
                            curLine.add(list.get(i - 1 - 1).get(j) + list.get(i - 1 - 1).get(j + 1));
                        }
                        curLine.add(0, 1);
                        curLine.add(1);
                        list.add(curLine);
                    }
                }
            }
        }
        return list;
    }
}
```

Discuss中给出的方法更加简洁

```Java
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>(numRows);
        List<Integer> row = new LinkedList<>();
        for (int i = 0; i < numRows; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++)
                row.set(j, row.get(j) + row.get(j + 1));
            list.add(new LinkedList<>(row));
        }
        return list;
    }
}
```

其原理就是每次都在当前行最左边或者最右边+1,然后在此基础上有

row[i] = row[i] + row[i + 1]成立.

因为下一层是基于当前一层的结果而生成的.