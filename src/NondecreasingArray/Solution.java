package NondecreasingArray;

/**
 * Created by liutaotao on 2018/4/4.
 */
public class Solution {
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for (int i = 1; i < nums.length && cnt <= 1; i++) {
            if (nums[i - 1] > nums[i]) {
                cnt++;
                // 下面两句话就是所谓的贪心策略并且虽然你质疑他,但是他是对的.
                if (i - 2 >= 0 && nums[i - 2] > nums[i]) nums[i] = nums[i - 1];
                else nums[i - 1] = nums[i];
            }
        }
        return cnt <= 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 2, 3};
        Solution solution = new Solution();
        System.out.println(solution.checkPossibility(nums));
    }
}
