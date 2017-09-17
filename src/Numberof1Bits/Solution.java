package Numberof1Bits;

/**
 * Created by liutaotao on 2017/9/17.
 */
public class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        for (int i = 0; i < 33; i++) {
//            System.out.println(i + " : " + solution.hammingWeight(i));
//        }

        System.out.println(
                solution.hammingWeight(0x80000000)
        );
    }
}
