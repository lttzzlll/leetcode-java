### [Self Dividing Numbers](https://leetcode.com/problems/self-dividing-numbers/description/)

水题一个吧.


```Java
class Solution {
    static boolean isDivid(int m) {
        int n = m;
        while (n > 0) {
            int t = n % 10;
            if (t == 0) return false;
            if (m % t != 0) return false;
            n /= 10;
        }
        return true;
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new LinkedList<>();
        for (int i = left; i <= right; i++) {
            if (isDivid(i)) list.add(i);
        }
        return list;
    }
}
```