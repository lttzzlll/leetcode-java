package PowerofFour;

import java.util.HashSet;

/**
 * Created by liutaotao on 2018/4/23.
 */
public class Solution {
    public boolean isPowerOfFour(int num) {
        HashSet<Integer> set = new HashSet<>();
        int i = 1;
        while (i < Integer.MAX_VALUE && i > 0) {
            set.add(i);
            i <<= 2;
        }
        return set.contains(num);
    }

}
