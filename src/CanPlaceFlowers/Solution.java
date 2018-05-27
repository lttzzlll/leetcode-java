package CanPlaceFlowers;

/**
 * Created by liutaotao on 2018/5/27.
 */
public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int[] arr = new int[flowerbed.length + 2];
        for (int i = 1; i < flowerbed.length; i++) arr[i] = flowerbed[i];

        int lastPos = -1, cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (flowerbed[i] == 1) {
                cnt = i - lastPos;
                lastPos = i + 1;
            }
        }
        return false;
    }

}
