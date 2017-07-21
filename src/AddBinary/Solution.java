package AddBinary;

import java.math.BigInteger;

/**
 * Created by 10609 on 2017/7/20.
 */
public class Solution {
    public String addBinary(String a, String b) {
        BigInteger val1 = new BigInteger(a, 2);
        BigInteger val2 = new BigInteger(b, 2);
        BigInteger val = val1.add(val2);
        return val.toString(2);
    }

    public static void main(String[] args) {
        String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
        Solution solution = new Solution();
        String res = solution.addBinary(a, b);
        System.out.println(res);
    }
}
