package MajorityElement;

/**
 * Created by liutaotao on 2017/9/5.
 */
public class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];
        int res = -1, cnt = 0;
        for (int i : nums) {
            if (cnt == 0) {
                res = i;
                cnt = 1;
            } else if (i == res) {
                cnt++;
            } else {
                cnt--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 3, 4};
        Solution solution = new Solution();
        int res = solution.majorityElement(arr);
        System.out.println(res);
    }
}
