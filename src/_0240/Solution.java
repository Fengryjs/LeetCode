package _0240;

public class Solution {
    /**
     * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
     *
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     * 示例 1：
     * 输入：matrix = [[1,4,7,11,15],
     *                [2,5,8,12,19],
     *                [3,6,9,16,22],
     *                [10,13,14,17,24],
     *                [18,21,23,26,30]], target = 5
     * 输出：true
     * 示例 2：
     *
     *
     * 输入：matrix = [[1,4,7,11,15],
     *                [2,5,8,12,19],
     *                [3,6,9,16,22],
     *                [10,13,14,17,24],
     *                [18,21,23,26,30]], target = 20
     * 输出：false
     *
     *
     * 提示：
     *
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= n, m <= 300
     * -109 <= matrix[i][j] <= 109
     * 每行的所有元素从左到右升序排列
     * 每列的所有元素从上到下升序排列
     * -109 <= target <= 109
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int x = 0;
        int y = 0;
        while (true) {
            if (matrix[x][y] == target)
                return true;
            else {
                if (matrix[x][y] > target) {
                    if ((x == 0 && y == 0) )
                        return false;
                    else {
                        if (x == 0) {
                            if (matrix[x][y - 1] < target)
                                return false;
                            else
                                y--;
                        }
                        else if (y == 0) {
                            if (matrix[x - 1][y] < target)
                                return false;
                            else x--;
                        } else {
                            if (matrix[x][y - 1] < target && matrix[x- 1][y] < target);
                        }
                    }
                } else {
                    // 找到大的当中比较小的那个
                    if (x == matrix.length - 1 && y == matrix[0].length - 1)
                        return false;
                    else {
                        if (x == matrix.length - 1|| matrix[x + 1][y] > matrix[x][y + 1])
                            y++;
                        else
                            x++;

                    }
                }
            }
        }
    }
}
