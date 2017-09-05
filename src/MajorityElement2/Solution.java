package MajorityElement2;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liutaotao on 2017/9/5.
 */
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new LinkedList<>();
        int m = -1, n = -1, cnt1 = 0, cnt2 = 0;
        for (int i : nums) {
            if (cnt1 == 0 && n != i) {
                m = i;
                cnt1 = 1;
                continue;
            }
            if (cnt2 == 0 && m != i) {
                n = i;
                cnt2 = 1;
                continue;
            }

            if (m == i) {
                cnt1++;
            } else if (n == i) {
                cnt2++;
            } else {
                if (cnt1 > 0)
                    cnt1--;
                if (cnt2 > 0)
                    cnt2--;
            }

//            System.out.println(String.format("%d: %d, %d: %d", m, cnt1, n, cnt2));
        }

        if (cnt1 > 0) {
            cnt1 = 0;
            for (int i : nums)
                if (i == m) cnt1++;

            if (cnt1 > nums.length / 3)
                res.add(m);
        }
        if (cnt2 > 0) {
            cnt2 = 0;
            for (int i : nums)
                if (i == n) cnt2++;

            if (cnt2 > nums.length / 3)
                res.add(n);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 1, 1, 1, 2, 1};
        Solution solution = new Solution();
        List<Integer> res = solution.majorityElement(arr); // 0 1 2
        for (Integer i : res) {
            System.out.println(i);
        }
    }
}
