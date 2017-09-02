package SingleNumber;

/**
 * Created by liutaotao on 2017/9/2.
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i : nums) {
            res ^= i;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{};
        Solution solution = new Solution();
        System.out.println(solution.singleNumber(arr));
    }
}
