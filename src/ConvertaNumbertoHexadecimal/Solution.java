package ConvertaNumbertoHexadecimal;

/**
 * Created by liutaotao on 2017/9/17.
 */
public class Solution {
//    char[] map = new char[16];
//
//    public Solution() {
//        map[0] = '0';
//        map[1] = '1';
//        map[2] = '2';
//        map[3] = '3';
//        map[4] = '4';
//        map[5] = '5';
//        map[6] = '6';
//        map[7] = '7';
//        map[8] = '8';
//        map[9] = '9';
//        map[10] = 'a';
//        map[11] = 'b';
//        map[12] = 'c';
//        map[13] = 'd';
//        map[14] = 'e';
//        map[15] = 'f';
//    }
//
//        public String toHex(int num) {
//            if (num == 0) return "0";
//            Stack<Character> stack = new Stack<>();
//            long res = 0;
//            int i = 0;
//            while (num != 0) {
//                if ((num & 1) == 1) {
//                    res += (long)Math.pow(2, i);
//                }
//                num >>>= 1;
//                i++;
//            }
////            System.out.println(res);
//            while (res != 0) {
//                stack.add(map[(int) (res % 16)]);
//                res >>>= 4;
//            }
//    //        while (num != 0) {
//    //            stack.add(map[Math.abs(num) % 16]);
//    //            num >>>= 4;
//    //        }
//            StringBuilder sb = new StringBuilder();
//            while (!stack.isEmpty()) {
//                sb.append(stack.pop());
//            }
//            return sb.toString();
//    }

    char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public String toHex(int num) {
        if (num == 0) return "0";
        String res = "";
        while (num != 0) {
            res += map[(num & 15)];
            num >>>= 4;
        }
        return res;
    }

    public static void main(String[] args) {
//        int n = 26;
        int n = -1;
        Solution solution = new Solution();
        System.out.println(solution.toHex(n));
    }
}
