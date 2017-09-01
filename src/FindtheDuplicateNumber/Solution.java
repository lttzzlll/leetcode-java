package FindtheDuplicateNumber;

/**
 * Created by liutaotao on 2017/9/1.
 */
public class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 7, 5, 6, 9, 4, 2, 8, 5, 1};
        System.out.println(nums.length);
        Solution solution = new Solution();
        System.out.println(solution.findDuplicate(nums));
    }
}
