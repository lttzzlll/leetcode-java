package PascalsTriangleII;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liutaotao on 2018/4/3.
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>(rowIndex);
        for (int i = 0; i < rowIndex + 1; i++) {
            list.add(0, 1);
            for (int j = 1; j < list.size() - 1; j++)
                list.set(j, list.get(j) + list.get(j + 1));
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int num = 0; num < 10; num++) {
            List<Integer> list = solution.getRow(num);
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println("-----------------");
        }
    }
}