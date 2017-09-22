package DetectCapital;

/**
 * Created by liutaotao on 2017/9/22.
 */
public class Solution {
//    public boolean detectCapitalUse(String word) {
//        if (word.isEmpty() || word.length() == 1) return true;
//        char[] res = word.toCharArray();
//        if (res[0] >= 65 && res[0] <= 90) { // upper case
//            if (res[1] >= 65 && res[1] <= 90) {
//                for (int i = 2; i < res.length; i++) {
//                    if (!(res[i] >= 65 && res[i] <= 90)) {
//                        return false;
//                    }
//                }
//                return true;
//            } else { // lower case
//                for (int i = 1; i < res.length; i++) {
//                    if (!(res[i] >= 97 && res[i] <= 122)) {
//                        return false;
//                    }
//                }
//                return true;
//            }
//        } else {
//            for (int i = 1; i < res.length; i++) {
//                if (!(res[i] >= 97 && res[i] <= 122)) {
//                    return false;
//                }
//            }
//            return true;
//        }
//    }

    public boolean detectCapitalUse(String word) {
        return word.substring(1).equals(word.substring(1).toLowerCase()) || word.equals(word.toUpperCase());
    }

    public static void main(String[] args) {
//        String word = "USA";
        String word = "FFFFFFFFFFFFFFFFFFFFf";
        Solution solution = new Solution();
        System.out.println(solution.detectCapitalUse(word));
    }
}
