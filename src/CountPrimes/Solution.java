package CountPrimes;

/**
 * Created by liutaotao on 2018/5/16.
 */
public class Solution {
    // 素数筛选法
    public int countPrimes(int n) {
        if (n == 0) return 0;
        int cnt = 0;
        int endpoint = (int) Math.sqrt(n) + 1;
        // 默认所有的数都是素数,然后从中筛选出非素数
        boolean[] noPrimes = new boolean[n + 1];
        noPrimes[0] = true;
        noPrimes[1] = true;
        for (int i = 2; i <= endpoint; i++) {
            int j = 2;
            while (true) {
                if (i * j >= n) break;
                noPrimes[i * j] = true;
                j++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (!noPrimes[i]) {
                cnt++;
//                System.out.println(i);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int n = 100;
        Solution solution = new Solution();
        System.out.println(solution.countPrimes(n));
    }
}
