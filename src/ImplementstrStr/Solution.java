package ImplementstrStr;

/**
 * Created by liutaotao on 2017/8/30.
 */
public class Solution {
    //    public int strStr(String haystack, String needle) {
//        if (haystack.equals(needle)) {
//            return 0;
//        }
//        if (haystack.isEmpty()) {
//            return -1;
//        }
//        return haystack.indexOf(needle);
//    }
    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i; // find
                if (i + j == haystack.length()) return -1; // not find
                if (needle.charAt(j) != haystack.charAt(i + j)) break; // not equal
            }
        }
    }

}
