package IntegerToEnglishWords;

/**
 * Created by liutaotao on 2017/8/24.
 */

/**
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
 * <p>
 * For example,
 * 123 -> "One Hundred Twenty Three"
 * 12345 -> "Twelve Thousand Three Hundred Forty Five"
 * 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 */
public class Solution {
//    private final String[] LESS_THAN_100 = {
//            "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
//    };
//    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
//    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"}; // 1000

//    public String numberToWords(int num) {
//        if (num == 0) {
//            return "Zero";
//        }
//
//        int i = 0;
//        String words = "";
//        while (num > 0) {
//            if (num % 1000 != 0) {
//                words = helper(num % 1000) + THOUSANDS[i] + " " + words;
//            }
//            num /= 1000;
//            i++;
//        }
//        return words.trim();
//    }

//    public String helper(int num) {
//        if (num == 0) {
//            return "";
//        } else if (num < 20) {
//            return LESS_THAN_20[num] + " ";
//        } else if (num < 100) {
//            return TENS[num / 10] + " " + helper(num % 10);
//        } else {
//            return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
//        }
//    }

//    private int pow(int m, int n) {
//        int res = 1;
//        for (int i = 0; i < n; i++) {
//            res *= m;
//        }
//        return res;
//    }

    public String numberToWords(int num) {
        if (num < 0) {
            return "";
        }
        if (num == 0) {
            return "Zero";
        }

        int segment1 = num / 1000000000;
        int segment2 = num % 1000000000 / 1000000;
        int segment3 = num % 1000000 / 1000;
        int segment4 = num % 1000;

        String res = "";
        if (segment1 > 0) {
            res += numToWordsLessThan1000(segment1) + " " + "Billion";
        }
        if (segment2 > 0) {
            res += numToWordsLessThan1000(segment2) + " " + "Million";
        }
        if (segment3 > 0) {
            res += numToWordsLessThan1000(segment3) + " " + "Thousand";
        }
        if (segment4 > 0) {
            res += numToWordsLessThan1000(segment4);
        }
        return res.trim();
    }

    private String numToWordsLessThan1000(int num) {
        // lower boundary high boundary
        if (num == 0 || num >= 1000) {
            return "";
        }
        String res = "";
        if (num >= 100) {
            res += numToWordsBase(num / 100) + " " + "Hundred";
        }
        num %= 100;
        if (num > 20) {
            res += numToWordsBase(num / 10 * 10);
            if (num % 10 != 0) {
                res += numToWordsBase(num % 10);
            }
        } else if (num > 0) {
            res += numToWordsBase(num);
        }
        return res;
    }

    private String numToWordsBase(int num) {
        String result = " ";
        switch (num) {
            case 1: result += "One"; break;
            case 2: result += "Two"; break;
            case 3: result += "Three"; break;
            case 4: result += "Four"; break;
            case 5: result += "Five"; break;
            case 6: result += "Six"; break;
            case 7: result += "Seven"; break;
            case 8: result += "Eight"; break;
            case 9: result += "Nine"; break;
            case 10: result += "Ten"; break;
            case 11: result += "Eleven"; break;
            case 12: result += "Twelve"; break;
            case 13: result += "Thirteen"; break;
            case 14: result += "Fourteen"; break;
            case 15: result += "Fifteen"; break;
            case 16: result += "Sixteen"; break;
            case 17: result += "Seventeen"; break;
            case 18: result += "Eighteen"; break;
            case 19: result += "Nineteen"; break;
            case 20: result += "Twenty"; break;
            case 30: result += "Thirty"; break;
            case 40: result += "Forty"; break;
            case 50: result += "Fifty"; break;
            case 60: result += "Sixty"; break;
            case 70: result += "Seventy"; break;
            case 80: result += "Eighty"; break;
            case 90: result += "Ninety"; break;
        }
        return result;
    }

    public static void main(String[] args) {
        int num = 1234567;
        Solution solution = new Solution();
        String res = solution.numberToWords(num);
        System.out.println(res);
    }
}
