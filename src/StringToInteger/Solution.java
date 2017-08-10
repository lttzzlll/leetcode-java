public class Solution {
    public int myAtoi(String str) {
       if (str == null  || str.length() < 1) {
           return 0;
       }
        str = str.trim();
        // res 自身的容积要足够大，大于Integer所能标识的范围，这样在 res * 10的时候不会有溢出变成负数因而变小的结果
        double res = 0;
        boolean flag = true;
        int i = 0;
        if (str.charAt(0) == '-') {
            flag = false;
            i++;
        } else if (str.charAt(0) == '+') {
            flag = true;
            i++;
        }

        for (; i < str.length(); i++) {
            int d = str.charAt(i) - '0';
            if (d > 9 || d < 0) {
                break;
            }
            if (flag) {
                res = res * 10 + d;
                if (res > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
            } else {
                res = res * 10 - d;
                if (res < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }
        }

        return (int)res;
    }
}