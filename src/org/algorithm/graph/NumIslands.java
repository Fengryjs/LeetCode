package org.algorithm.graph;

/**
 * 200.岛屿数量
 * 中等
 *
 * 相关标签
 * 相关企业
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *
 *
 * 示例 1：
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 *
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 *
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 */
public class NumIslands {
    public int numIslands(char[][] grid) {
        int res = 0;
        int currentX;
        int currentY;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    currentX = i;
                    currentY = j;
                    dfs(grid, res, currentX, currentY);
                    res += 1;
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int res, int currentX, int currentY) {
        grid[currentX][currentY] = '0';
        if (currentX != 0 && grid[currentX - 1][currentY] == '1') {
            dfs(grid, res, currentX - 1, currentY);
        }
        if (currentX != grid.length - 1 && grid[currentX + 1][currentY] == '1') {
            dfs(grid, res, currentX + 1, currentY);
        }
        if (currentY != 0 && grid[currentX][currentY - 1] == '1') {
            dfs(grid, res, currentX, currentY - 1);
        }
        if (currentY != grid[currentX].length - 1 && grid[currentX][currentY + 1] == '1') {
            dfs(grid, res, currentX, currentY + 1);
        }
    }
}
