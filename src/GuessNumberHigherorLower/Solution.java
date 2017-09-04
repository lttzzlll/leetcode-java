package GuessNumberHigherorLower;

/**
 * Created by liutaotao on 2017/8/31.
 */
class GuessGame {
    public int guess(int num) {
        if (1702766719 < num) return -1;
        else if (1702766719 > num) return 1;
        else return 0;
    }
}

public class Solution extends GuessGame {
    private int f(int low, int high) {
        if (low > high) return low;
        int mid = low + (high - low) / 2;
        if (guess(mid) == -1) return f(low, mid - 1);
        else if (guess(mid) == 1) return f(mid + 1, high);
        else return mid;
    }

    public int guessNumber(int n) {
        return f(1, n);
    }

    public static void main(String[] args) {
        int a = 2126753390;
        Solution solution = new Solution();
        System.out.println(solution.guessNumber(a));
    }

}
