package CanPlaceFlowers;

/**
 * Created by liutaotao on 2018/5/27.
 */
public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n <= 0) return true;
        int len = flowerbed.length;
        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 0) {
                if (i == 0 && i == len - 1 ||
                        i == 0 && i + 1 < len && flowerbed[i + 1] == 0 ||
                        i == len - 1 && i - 1 >= 0 && flowerbed[i - 1] == 0 ||
                        i > 0 && i < len - 1 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    if (--n == 0) return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 0, 0, 0, 0, 1};
//        int[] nums = new int[]{0};
//        int[] nums = new int[]{1, 0};
        int[] nums = new int[]{0, 1, 0};
        int n = 1;
        Solution solution = new Solution();

        System.out.println(solution.canPlaceFlowers(nums, n));
    }
}
