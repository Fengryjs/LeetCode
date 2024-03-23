package _0073;

public class Solution {
    public void setZeroes(int[][] matrix) {
        int[] columns = new int[matrix.length];
        int[] rows = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    columns[i] = 1;
                    rows[j] = 1;
                }
            }
        }
        for (int i = 0; i < columns.length; i++) {
            if (columns[i] == 0) {
                for (int j = 0; j < rows.length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < rows.length; j++) {
            if (rows[j] == 0) {
                for (int i = 0; i < columns.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
