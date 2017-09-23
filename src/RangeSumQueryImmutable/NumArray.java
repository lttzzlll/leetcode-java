package RangeSumQueryImmutable;

/**
 * Created by liutaotao on 2017/9/23.
 */
public class NumArray {
    private int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        NumArray obj = new NumArray(nums);
//        System.out.println(obj.sumRange(1, 3));
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                System.out.println(String.format("(%d, %d): %d", i, j, obj.sumRange(i, j)));
            }
        }
    }
}
