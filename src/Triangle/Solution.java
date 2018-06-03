package Triangle;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liutaotao on 2018/6/3.
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new LinkedList<>();
        for (int i = 0; i < triangle.size(); i++) {
            dp.add(new LinkedList<>());
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp.get(i).add(0);
            }
        }
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (i == triangle.size() - 1) {
                    dp.get(i).set(j, triangle.get(i).get(j));
                } else {
                    int t = Math.min(dp.get(i + 1).get(j), dp.get(i + 1).get(j + 1));
                    dp.get(i).set(j, triangle.get(i).get(j) + t);
                }
            }
        }
        return dp.get(0).get(0);
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new LinkedList<>();
        triangle.add(new LinkedList<>());
        triangle.add(new LinkedList<>());
        triangle.add(new LinkedList<>());
        triangle.add(new LinkedList<>());

        triangle.get(0).add(2);

        triangle.get(1).add(3);
        triangle.get(1).add(4);

        triangle.get(2).add(6);
        triangle.get(2).add(5);
        triangle.get(2).add(7);

        triangle.get(3).add(4);
        triangle.get(3).add(1);
        triangle.get(3).add(8);
        triangle.get(3).add(3);

        Solution solution = new Solution();
        System.out.println(solution.minimumTotal(triangle));
    }
}
