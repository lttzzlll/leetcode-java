package RomanToInteger;

import java.util.HashMap;

/**
 * Created by liutaotao on 2017/8/24.
 */
public class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);

        int sum = hashMap.get(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (hashMap.get(s.charAt(i - 1)) < hashMap.get(s.charAt(i)) ) {
                sum += hashMap.get(s.charAt(i)) - hashMap.get(s.charAt(i - 1)) * 2;
            } else {
                sum += hashMap.get(s.charAt(i));
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "DCXXI"; // 500 + 100  + 10 + 10 + 1
        Solution solution =  new Solution();
        int res = solution.romanToInt(s);
        System.out.println(res);
    }
}
