package NQueens;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liutaotao on 2018/7/22.
 */
public class Solution {

    static boolean check(int[] board, int row, int col) {
        for (int i = 0; i < row; i++)
            if (board[i] == col || board[i] - col == row - i || col - board[i] == row - i)
                return false;
        return true;
    }

    void find(List<List<String>> list, int[] board, int n, int row) {
        if (row == n) {
            List<String> boards = new ArrayList<>();
            char[] chars = new char[board.length];
            for (int col : board) {
                for (int i = 0; i < chars.length; i++)
                    chars[i] = (col == i ? 'Q' : '.');
                boards.add(new String(chars));
            }
            list.add(boards);
        } else {
            for (int col = 0; col < n; col++) {
                if (check(board, row, col)) {
                    board[row] = col;
                    find(list, board, n, row + 1);
                }
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        int[] board = new int[n];
        find(list, board, n, 0);
        return list;
    }

    public static void main(String[] args) {
        int n = 8;
        Solution solution = new Solution();
        List<List<String>> list = solution.solveNQueens(n);
        for (List<String> rows : list) {
            for (String col : rows) {
                System.out.println(col);
            }
            System.out.println();
        }
    }
}
