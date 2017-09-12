package ThirdMaximumNumber;

/**
 * Created by liutaotao on 2017/9/8.
 */
public class Solution {

//    public int thirdMax(int[] nums) {
//        if (nums.length == 1) return nums[0];
//        if (nums.length == 2) return Math.max(nums[0], nums[1]);
//        int first = nums[0], second = nums[0], third = nums[0];
//        int i = 1;
//        while (i < nums.length) {
//            if (first > second) break;
//            if (nums[i] > first) {
//                second = first;
//                first = nums[i];
//                break;
//            } else if (nums[i] < first) {
//                second = nums[i];
//                break;
//            }
//            i++;
//        }
//        if (i == nums.length) return first;
//        i++;
//        while (i < nums.length) {
//            if (second > third) break;
//            if (nums[i] > first) {
//                if (second < third) {
//                    third = second;
//                }
//                second = first;
//                first = nums[i];
//                break;
//            } else if (nums[i] == first) {
//            } else if (nums[i] > second) {
//                third = second;
//                second = nums[i];
//                break;
//            } else if (nums[i] == second) {
//            } else if (nums[i] < second) {
//                third = nums[i];
//                break;
//            }
//            i++;
//        }
//        if (i == nums.length) return first;
//        i++;
//        while (i < nums.length) {
//            if (nums[i] > first) {
//                third = second;
//                second = first;
//                first = nums[i];
//            } else if (nums[i] == first) {
//
//            } else if (nums[i] > second) {
//                third = second;
//                second = nums[i];
//            } else if (nums[i] == second) {
//
//            } else if (nums[i] > third) {
//                third = nums[i];
//            }
//            i++;
//        }
//        return first > second && second > third ? third : first;
//    }

    public int thirdMax(int[] nums) {
        Integer max1 = null, max2 = null, max3 = null;
        for (Integer n : nums) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
            if (max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{2, 2, 3, 1};
        int[] arr = new int[]{1, 1, 2};
//        int[] arr = new int[]{3, 2, 1};
//        int[] arr = new int[]{1, 2, 2};
//        int[] arr = new int[]{1, 2, 2, 5, 3, 5};
//        int[] arr = new int[]{1, -2147483648, 2};
        Solution solution = new Solution();
        System.out.println(solution.thirdMax(arr));
    }
}
