package PlusOne;

/**
 * Created by 10609 on 2017/7/20.
 */
public class Solution {

//    public int[] plusOne(int[] digits) {
//        Stack<Integer> stack = new Stack<>();
//        int carry = 1;
//        for (int i = digits.length - 1; i >= 0; i--) {
//            stack.push((digits[i] + carry) % 10);
//            carry = (digits[i] + carry) / 10;
//        }
//        if (carry > 0) {
//            stack.push(carry);
//        }
//
//        int[] res = new int[stack.size()];
//        int pos = 0;
//        while (!stack.isEmpty()) {
//            res[pos++] = stack.pop();
//        }
//        return res;
//    }


    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0 ; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] arr= new int[digits.length + 1];
        arr[0] = 1;
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 9, 9, 9};
        Solution solution = new Solution();
        int[] res = solution.plusOne(arr);
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
