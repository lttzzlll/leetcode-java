class Solution {
    public int arrangeCoins(int n) {
        long res = 0;
        int i = 0;
        while (res + (i + 1) <= n) {
            i += 1;
            res += i;
        }
        return i;
    }

    public static void main(String[] args) {
        int n = 10;
        Solution s = new Solution();
        for (int i = 1; i <= n; i++) {
            int r = s.arrangeCoins(i);
            System.out.println(i + " : " + r);
        }
        System.out.println(s.arrangeCoins(2147483647));
    }
}