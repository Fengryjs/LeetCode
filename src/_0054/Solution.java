package _0054;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
     *
     * 示例 1：
     *
     *
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int up = 0;
        int left = -1;
        int x = 0;
        int y = 0;
        int count = 0;
        boolean toRight = true;
        boolean toDown = false;
        boolean toLeft = false;
        boolean toUp = false;
        int down = matrix.length;
        int right = matrix[0].length;
        while (count != matrix.length * matrix[0].length) {
            System.out.println(x + " " + y);
            result.add(matrix[y][x]);
            count++;
            if (toRight) {
                if (x + 1 == right) {
                    right = x;
                    toRight = false;
                    toDown = true;
                    y++;
                } else {
                    x++;
                }
            } else if (toDown) {
                if (y + 1 == down) {
                    down = y;
                    toDown = false;
                    toLeft = true;
                    x--;
                } else {
                    y++;
                }
            } else if (toLeft) {
                if (x - 1 == left) {
                    left = x;
                    toLeft = false;
                    toUp = true;
                    y--;
                } else {
                    x--;
                }
            } else if (toUp) {
                if (y - 1 == up) {
                    up = y;
                    toUp = false;
                    toRight = true;
                    x++;
                } else {
                    y--;
                }
            }
            //
        }
        return result;
    }
}
