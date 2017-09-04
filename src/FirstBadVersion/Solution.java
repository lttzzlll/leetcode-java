package FirstBadVersion;

/**
 * Created by liutaotao on 2017/8/30.
 */
class VersionControl {
    boolean isBadVersion(int version) {
        return version >= 1702766719;
    }
}

public class Solution extends VersionControl {
    private int f(int left, int right) {
        if (left > right) {
            return left;
        }
        int mid = left + (right - left) / 2;

        if (isBadVersion(mid)) {
            return f(left, mid - 1);
        } else {
            return f(mid + 1, right);
        }
    }

    public int firstBadVersion(int n) {
        return f(1, n);
    }

    public static void main(String[] args) {
        int n = 2126753390;
        Solution solution = new Solution();
        System.out.println(solution.firstBadVersion(n));
    }

}
