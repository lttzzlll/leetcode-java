package NumberComplement;

/**
 * Created by liutaotao on 2018/4/24.
 */
public class Solution {
//    public int findComplement(int num) {
//        String bin = Integer.toBinaryString(num);
//        String res = "";
//        for (char c :
//                bin.toCharArray()) {
//            if (c == '0') res += '1';
//            else res += '0';
//        }
//        return Integer.valueOf(res, 2);
//    }

    public int findComplement(int num) {

        int mask = (Integer.highestOneBit(num) << 1) - 1;
        System.out.println(Integer.toBinaryString(Integer.highestOneBit(num) - 1));
        System.out.println(Integer.toBinaryString((Integer.highestOneBit(num) << 1) - 1));
        System.out.println(Integer.toBinaryString(mask));
        return num ^ mask;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findComplement(5));
    }
}
