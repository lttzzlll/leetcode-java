package TrappingRainWater2;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by liutaotao on 2017/8/21.
 */

class Point {
    public int x;
    public int y;

    public Point(int i, int j) {
        this.x = i;
        this.y = j;
    }
}

public class Solution {


    public void disp(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(String.format("%4d", mat[i][j]));
            }
            System.out.println();
        }
    }


    public int max(int a, int b) {
        return a > b ? a : b;
    }

    public int min(int a, int b, int c, int d) {
        return min(min(a, b), min(c, d));
    }

    public int min(int a, int b) {
        return a < b ? a : b;
    }

//    public int trapRainWater(int[][] heightMap) {
//        if (heightMap.length < 3 || heightMap[0].length < 3) {
//            return 0;
//        }
//
//        int m = heightMap.length, n = heightMap[0].length;
//
//        int[][] left = new int[m][n];
//        int[][] top = new int[m][n];
//        int[][] right = new int[m][n];
//        int[][] bottom = new int[m][n];
//
//        int curMax;
//
//        for (int i = 0; i < m; i++) {
//            curMax = 0;
//            for (int j = 0; j < n; j++) {
//                curMax = max(curMax, heightMap[i][j]);
//                left[i][j] = curMax;
//            }
//        }
//
//        for (int i = 0; i < m; i++) {
//            curMax = 0;
//            for (int j = n - 1; j >= 0; j--) {
//                curMax = max(curMax, heightMap[i][j]);
//                right[i][j] = curMax;
//            }
//        }
//
//        for (int i = 0; i < n; i++) {
//            curMax = 0;
//            for (int j = 0; j < m; j++) {
//                curMax = max(curMax, heightMap[j][i]);
//                top[j][i] = curMax;
//            }
//        }
//
//        for (int i = 0; i < n; i++) {
//            curMax = 0;
//            for (int j = m - 1; j >= 0; j--) {
//                curMax = max(curMax, heightMap[j][i]);
//                bottom[j][i] = curMax;
//            }
//        }
////        disp(left);disp(right);disp(top);disp(bottom);
//        int sum = 0;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                int min_val = min(left[i][j], right[i][j], top[i][j], bottom[i][j]);
//                int sub_val = min_val - heightMap[i][j];
////                System.out.println(String.format("min val: %d, sub val: %d", min_val, sub_val));
//                int temp = max(0, sub_val);
////                System.out.println(String.format("(%d, %d): %4d", i, j, temp));
//                System.out.print(String.format("%4d", temp));
//                sum += temp;
//            }
//            System.out.println();
//        }
//        return sum;
//    }
//
//    public int trapRainWater(int[][] heightMap) {
//        if (heightMap.length < 3 || heightMap[0].length < 3) {
//            return 0;
//        }
//        int m = heightMap.length, n = heightMap[0].length;
//        int[][] peakMap = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                peakMap[i][j] = Integer.MAX_VALUE;
//            }
//        }
//        Queue<Point> queue = new LinkedList<Point>();
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if ((i == 0 || i == m - 1) || (j == 0 || j == n - 1)) {
//                    peakMap[i][j] = heightMap[i][j];
//                    queue.add(new Point(i, j));
//                }
//            }
//        }
//        Point[] dir = new Point[4];
//        dir[0] = new Point(1, 0);
//        dir[1] = new Point(0, 1);
//        dir[2] = new Point(-1, 0);
//        dir[3] = new Point(0, -1);
//
//        while (!queue.isEmpty()) {
//            Point point = queue.poll();
//            int x = point.x, y = point.y;
//            for (int i = 0; i < dir.length; i++) {
//                Point p = dir[i];
//                int dx = p.x, dy = p.y;
//                int nx = x + dx, ny = y + dy;
//                if (nx <= 0 || nx >= m - 1 || ny <= 0 || ny >= n - 1) {
//                    continue;
//                }
//                int limit = max(peakMap[x][y], heightMap[nx][ny]);
//                if (peakMap[nx][ny] > limit) {
//                    peakMap[nx][ny] = limit;
//                    queue.add(new Point(nx, ny));
//                }
//            }
//        }
//        int sum = 0;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                int temp = peakMap[i][j] - heightMap[i][j];
//                sum += temp;
//            }
//        }
//        return sum;
//    }

    // inner class
    class Cell {
        int x;
        int y;
        int h;

        public Cell(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }

    public int trapRainWater(int[][] height) {
        if (height == null || height.length < 3 || height[0].length < 3) {
            return 0;
        }

        // inner class & anonymous class
        // ordered by height
        // min heap
        PriorityQueue<Cell> queue = new PriorityQueue<Cell>(1, new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                return o1.h - o2.h;
            }
        });
        int n = height.length;
        int m = height[0].length;
        boolean[][] visited = new boolean[n][m];

        // Note: 四个角上的元素被重复插入了
        // 四周的元素都被访问过了,以后就不能再访问了
        for (int i = 0; i < n; i++) {
            visited[i][0] = true;
            visited[i][m - 1] = true;
            queue.offer(new Cell(i, 0, height[i][0]));
            queue.offer(new Cell(i, m - 1, height[i][m - 1]));
        }
        for (int i = 1; i < m - 1; i++) {
            visited[0][i] = true;
            visited[n - 1][i] = true;
            queue.offer(new Cell(0, i, height[0][i]));
            queue.offer(new Cell(n - 1, i, height[n - 1][i]));
        }

        // 每个被访问的元素的上下左右四个方向,顺序不重要,但都要涉及到
        int[] xs = {0, 0, 1, -1};
        int[] ys = {1, -1, 0, 0};

        int sum = 0;
        // 此处的优先队列是一个最小堆,每次在栈顶都会弹出一个最小的元素
        while (!queue.isEmpty()) {
            // 此处的cell代表的是当前cell四周的cell中的最大的高度, 下面要和当前cell的真实高度作比较
            // 如果大于当前cell的高度,就用这个高度差作为保存雨水的量,否则,就设置为0,表示当前cell无法保存雨水
            Cell cell = queue.poll();
            // 每一个pop出来的元素都可以向四周扩展
            for (int i = 0; i < 4; i++) {
                int nx = cell.x + xs[i];
                int ny = cell.y + ys[i];
                // 不是边界上的元素而且没有被访问过
                // 此处的边界检查是为了防止访问visited数组的时候越界
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    sum += Math.max(0, cell.h - height[nx][ny]);
                    // 将当前cell压入队列中,表示当前cell的高度,不是该cell的真实高度,而是可以构成"墙"hold住雨水的最高的高度
                    queue.offer(new Cell(nx, ny, max(height[nx][ny], cell.h)));
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] heightMap = new int[][]{
//                {1, 4, 3, 1, 3, 2},
//                {3, 2, 1, 3, 2, 4},
//                {2, 3, 3, 2, 3, 1}
                {12, 13, 1, 12},
                {13, 4, 13, 12},
                {13, 8, 10, 12},
                {12, 13, 12, 12},
                {13, 13, 13, 13}
        };
        Solution solution = new Solution();
        int res = solution.trapRainWater(heightMap);
        System.out.println(res);
//        PriorityQueue<Integer> queue = new PriorityQueue<>(1, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;
//            }
//        });
//        for (int i = 0; i < 10; i++) {
//            queue.offer(Integer.valueOf(i));
//        }
//        while (!queue.isEmpty()) {
//            System.out.println(queue.poll());
//        }
    }
}