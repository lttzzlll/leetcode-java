/**
 * Created by 10609 on 2017/7/20.
 */
package fourSum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

//    private Set<Integer> set = new HashSet<>();
//
//    private int convert(int a, int b, int c, int d) {
//        return a * 10 + b * 100 + c * 1000 + d * 10000;
//    }
//
//    public List<List<Integer>> fourSum(int[] nums, int target) {
//        // inorder -> order
//        Arrays.sort(nums);
//
//        List<List<Integer>> res = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                for (int k = j + 1; k < nums.length; k++) {
//                    for (int l = k + 1; l < nums.length; l++) {
//                        if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
//                            int flag = convert(nums[i], nums[j], nums[k], nums[l]);
//                            if (!set.contains(flag)) {
//                                List<Integer> temp = new ArrayList<>(4);
//                                temp.add(nums[i]);
//                                temp.add(nums[j]);
//                                temp.add(nums[k]);
//                                temp.add(nums[l]);
//                                res.add(temp);
//                                set.add(flag);
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return res;
//    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        int len = nums.length;
        if (nums == null || len < 4) {
            return res;
        }
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        if (4 * nums[0] > target || 4 * max < target) {
            return res;
        }
        int i, z;
        for (i = 0; i < len; i++) {
            z = nums[i];
            if (i > 0 && z == nums[i - 1]) { // skip duplicates
                continue;
            }
            if (z + 3 * max < target) { // skip small value
                continue;
            }
            if (4 * z == target) {
                if (i + 3 < len && nums[i + 3] == z) { // 4 nums[i] share the same value
                    res.add(Arrays.asList(z, z, z, z));
                }
                break; // > the next value > z, so, > target
            }
            threeSumForFourSum(nums, target - z, i + 1, len - 1, res, z);
        }
        return res;
    }


    private void threeSumForFourSum(int[] nums,
                                    int target,
                                    int low,
                                    int high,
                                    List<List<Integer>> fourSumList,
                                    int z1) {
        if (low + 2 > high) {
            return;
        }

        int max = nums[high];
        if (3 * nums[low] > target || 3 * max < target) {
            return;
        }
        int i, z;
        for (i = low; i < high - 1; i++) {
            z = nums[i];
            if (i > low && z == nums[i - 1]) { // skip duplicates
                continue;
            }
            if (z + 2 * max < target) { // skip small value
                continue;
            }
            if (3 * z > target) { // skip big value
                break;
            }
            if (3 * z == target) {
                if (i + 1 < high && nums[i + 2] == z) { //  share the same value
                    fourSumList.add(Arrays.asList(z1, z, z, z));
                }
                break;
            }
            twoSumForFourSum(nums, target - z, i + 1, high, fourSumList, z1, z);
        }
    }

    public void twoSumForFourSum(int[] nums,
                                 int target,
                                 int low,
                                 int high,
                                 List<List<Integer>> fourSumList,
                                 int z1,
                                 int z2) {
        if (low >= high) {
            return;
        }
        if (2 * nums[low] > target || 2 * nums[high] < target) {
            return;
        }

        int i = low, j = high, sum, x;
        while (i < j) {
            sum = nums[i] + nums[j];
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                fourSumList.add(Arrays.asList(z1, z2, nums[i], nums[j]));
                x = nums[i];
                while (++i < j && x == nums[i]) ;
                x = nums[j];
                while (i < --j && x == nums[j]) ;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-5, 5, 4, -3, 0, 0, 4, -2};
        int target = 4;
        Solution solution = new Solution();
        List<List<Integer>> lst = solution.fourSum(arr, target);
        for (List<Integer> list : lst) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}
