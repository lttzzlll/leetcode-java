package MinimumPathSum;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by liutaotao on 2017/11/23.
 */
public class Solution {
    /**
     * 深搜广搜都超时了.
     */
//    class Position {
//        int val;
//        int x;
//        int y;
//
//        public Position(int x, int y, int val) {
//            this.x = x;
//            this.y = y;
//            this.val = val;
//        }
//
//        public int getX() {
//            return x;
//        }
//
//        public int getY() {
//            return y;
//        }
//
//        public int getVal() {
//            return val;
//        }
//    }

//    public int minPathSum(int[][] grid) {
//        int minPath = Integer.MAX_VALUE;
//        Queue<Position> queue = new LinkedList<>();
//        queue.offer(new Position(0, 0, grid[0][0]));
//        while (!queue.isEmpty()) {
//            Position pos = queue.poll();
//            if (pos.getX() == grid.length - 1 && pos.getY() == grid[0].length - 1) {
//                if (pos.getVal() < minPath) minPath = pos.getVal();
//            }
//            // cut off
//            if (pos.getX() + 1 <= grid.length - 1 && pos.getVal() + grid[pos.getX() + 1][pos.getY()] < minPath)
//                queue.offer(new Position(pos.getX() + 1, pos.getY(), pos.getVal() + grid[pos.getX() + 1][pos.getY()]));
//            if (pos.getY() + 1 <= grid[0].length - 1 && pos.getVal() + grid[pos.getX()][pos.getY() + 1] < minPath)
//                queue.offer(new Position(pos.getX(), pos.getY() + 1, pos.getVal() + grid[pos.getX()][pos.getY() + 1]));
//        }
//        return minPath;
//    }


    /**
     * 深搜会超时,所以用广搜,虽然费空间.
     */


//    public int minPathSum(int[][] grid) {
//        int m = grid.length, n = grid[0].length;
//        int[][] path = new int[m][n];
//        path[0][0] = grid[0][0];
//        for (int i = 1; i < m; i++)
//            path[i][0] = path[i - 1][0] + grid[i][0];
//
//        for (int j = 1; j < n; j++)
//            path[0][j] = path[0][j - 1] + grid[0][j];
//
//        for (int i = 1; i < m; i++)
//            for (int j = 1; j < n; j++)
//                path[i][j] = Integer.min(path[i - 1][j], path[i][j - 1]) + grid[i][j];
//
//        return path[m - 1][n - 1];
//    }

//    public int minPathSum(int[][] grid) {
//        int m = grid.length, n = grid[0].length;
//        int[] pre = new int[m];
//        int[] cur = new int[m];
//        pre[0] = grid[0][0];
//        for (int i = 1; i < m; i++) pre[i] = pre[i - 1] + grid[i][0];
//        for (int j = 1; j < n; j++) {
//            cur[0] = pre[0] + grid[0][j];
//            for (int i = 1; i < m; i++)
//                cur[i] = Integer.min(cur[i - 1], pre[i]) + grid[i][j];
//            int[] temp = pre;
//            pre = cur;
//            cur = temp;
//        }
//        return pre[m - 1];
//    }
//    public int minPathSum(int[][] grid) {
//        int m = grid.length, n = grid[0].length;
//        int[] cur = new int[m];
//        cur[0] = grid[0][0];
//        for (int i = 1; i < m; i++) cur[i] = cur[i - 1] + grid[i][0];
//        for (int j = 1; j < n; j++) {
//            cur[0] += grid[0][j];
//            for (int i = 1; i < m; i++) {
//                cur[i] = Integer.min(cur[i - 1], cur[i]) + grid[i][j];
//            }
//        }
//        return cur[m - 1];
//    }
    private int solve(int[][] grid, int[][] memo, int x, int y) {
        if (x < 0 || y < 0) return 0;

        if (memo[x][y] != 0) return memo[x][y];

        if (x > 0 && y > 0)
            memo[x][y] = Integer.min(
                    solve(grid, memo, x - 1, y),
                    solve(grid, memo, x, y - 1)) + grid[x][y];
        else if (x == 0)
            memo[x][y] = solve(grid, memo, x, y - 1) + grid[x][y];
        else memo[x][y] = solve(grid, memo, x - 1, y) + grid[x][y];

        return memo[x][y];
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] memo = new int[m][n];
        return solve(grid, memo, m - 1, n - 1);
    }

    public static void main(String[] args) {
        int[][] arr = new int[200][200];
        String path = "/Users/liutaotao/Code/web/res.txt";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                for (int j = 0; j < row.length; j++) {
                    arr[i][j] = Integer.parseInt(row[j]);
                }
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        int[][] arr = new int[][]{
////                {1, 3, 1},
////                {1, 5, 1},
////                {4, 2, 1}
//                {1, 2},
//                {3, 4}
//        };
        for (int i = 0; i < arr.length; i++) {
//            System.out.println(i + " | " + arr[i].length);
            for (int j = 0; j < arr[i].length - 1; j++) {
                System.out.print(arr[i][j] + ",");
            }
            System.out.println(arr[i][arr.length - 1] + "\n");
        }

        Solution solution = new Solution();
        int res = solution.minPathSum(arr);
        System.out.println(res);
    }
}
