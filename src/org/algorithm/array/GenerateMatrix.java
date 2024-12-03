package org.algorithm.array;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[[1]]
 *
 *
 * 提示：
 *
 * 1 <= n <= 20
 */
public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int x = 0;
        int y = 0;
        int count = 1;
        int direction = 1;
        while (count <= n * n) {
            res[x][y] = count;
            count++;
            if (count == n * n + 1) {
                break;
            }
            if (direction == 1) {
                if (y == n - 1 || res[x][y + 1] != 0) {
                    direction = 2;
                    if (res[x + 1][y] != 0) {
                        direction = 3;
                    }
                }
            } else if (direction == 2) {
                if (x == n - 1 || res[x + 1][y] != 0) {
                    direction = 3;
                    if (res[x][y - 1] != 0) {
                        direction = 4;
                    }
                }
            } else if (direction == 3) {
                if (y == 0 || res[x][y - 1] != 0) {
                    direction = 4;
                    if (res[x - 1][y] != 0) {
                        direction = 1;
                    }
                }
            } else {
                if (x == 0 || res[x - 1][y] != 0) {
                    direction = 1;
                    if (res[x][y + 1] != 0) {
                        direction = 2;
                    }
                }
            }
            if (direction == 1) {
                y = y + 1;
            } else if (direction == 2) {
                x = x + 1;
            } else if (direction == 3) {
                y = y - 1;
            } else {
                x = x - 1;
            }
        }
        return res;
    }
}
