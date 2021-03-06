package PascalsTriangle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by liutaotao on 2018/4/2.
 */
public class Solution {
//    public List<List<Integer>> generate(int numRows) {
//        List<List<Integer>> list = new ArrayList<>(numRows);
//        if (numRows == 0) return list;
//        if (numRows == 1) {
//            List<Integer> firstline = new LinkedList<>();
//            firstline.add(1);
//            list.add(firstline);
//            return list;
//        } else if (numRows == 2) {
//            List<Integer> firstline = new LinkedList<>();
//            firstline.add(1);
//            List<Integer> secondline = new LinkedList<>();
//            secondline.add(1);
//            secondline.add(1);
//            list.add(firstline);
//            list.add(secondline);
//            return list;
//        } else {
//            List<Integer> firstline = new LinkedList<>();
//            firstline.add(1);
//            List<Integer> secondline = new LinkedList<>();
//            secondline.add(1);
//            secondline.add(1);
//            list.add(firstline);
//            list.add(secondline);
//            for (int i = 3; i <= numRows; i++) {
//                List<Integer> curline = new LinkedList<>();
//                for (int j = 0; j < list.get(i - 1 - 1).size() - 1; j++) {
//                    curline.add(list.get(i - 1 - 1).get(j) + list.get(i - 1- 1).get(j + 1));
//                }
//                curline.add(0, 1);
//                curline.add(1);
//                list.add(curline);
//            }
//            return list;
//        }
//    }

//
//    public List<List<Integer>> generate(int numRows) {
//        List<List<Integer>> list = new ArrayList<>(numRows);
//        if (numRows > 0) {
//            List<Integer> firstLine = new LinkedList<>();
//            firstLine.add(1);
//            list.add(firstLine);
//            if (numRows > 1) {
//                List<Integer> secondLine = new LinkedList<>();
//                secondLine.add(1);
//                secondLine.add(1);
//                list.add(secondLine);
//                if (numRows > 2) {
//                    for (int i = 3; i <= numRows; i++) {
//                        List<Integer> curLine = new LinkedList<>();
//                        for (int j = 0; j < list.get(i - 1 - 1).size() - 1; j++) {
//                            curLine.add(list.get(i - 1 - 1).get(j) + list.get(i - 1 - 1).get(j + 1));
//                        }
//                        curLine.add(0, 1);
//                        curLine.add(1);
//                        list.add(curLine);
//                    }
//                }
//            }
//        }
//        return list;
//    }


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

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int num = 0; num < 10; num++) {
            List<List<Integer>> list = solution.generate(num);
            System.out.println("----------------start-------");
            for (List<Integer> items : list) {
                for (Integer i : items) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
            System.out.println("-----------------end-----------");
        }
    }
}
