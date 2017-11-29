package RotateImage;

/**
 * Created by liutaotao on 2017/11/28.
 */
public class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        for (int row = 0; row < m / 2; row++) {
            for (int col = 0; col < m; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[m - 1 - row][col];
                matrix[m - 1 - row][col] = temp;
            }
        }

        for (int row = 1; row < m; row++) {
            for (int col = 0; col < row; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        Solution solution = new Solution();

        solution.rotate(mat);

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
