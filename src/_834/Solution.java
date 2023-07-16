package _834;
/**
 * 给定一个无向、连通的树。树中有 n 个标记为 0...n-1 的节点以及 n-1 条边 。
 * 给定整数 n 和数组 edges ， edges[i] = [ai, bi]表示树中的节点 ai 和 bi 之间有一条边。
 * 返回长度为 n 的数组 answer ，其中 answer[i] 是树中第 i 个节点与所有其他节点之间的距离之和。
 */

import sun.security.util.ArrayUtil;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 6 * 6 array                 一共n轮， 每轮将 i 到其他的点（0， 1， 。。。 i - 1， i + 1.。），计算最小可能的值
 * 0 0 0 0 0 0    0 1 1 0 0 0
 * 0 0 0 0 0 0    1 0 0 0 0 0
 * 0 0 0 0 0 0 => 1 0 0 1 1 1 =>
 * 0 0 0 0 0 0    0 0 1 0 0 0
 * 0 0 0 0 0 0    0 0 1 0 0 0
 * 0 0 0 0 0 0    0 0 1 0 0 0
 */

/**
 * 64 / 74 时间复杂度为 O(n²)
 */
class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        int[][] result = new int[n][n];
        System.out.println(edges.length);
        for (int i = 0; i < edges.length; i++) {
            int a_i = edges[i][0];
            int b_i = edges[i][1];
            result[a_i][b_i] = 1;
            result[b_i][a_i] = 1;
        }
        boolean changed = true;
        while (changed) {
            changed = false;
            // 每轮遍历 0 ~ n
            for (int i = 0; i < n; i++) {
                // 修改 i 和 其他的所有的点的距离
                for (int j = 0; j < n; j++) {
                    int initialLength = result[i][j];
                    if(i != j) {
                        // 对于这个点 进行这个点的 最短路径
                        for (int k = 0; k < n; k++) {
                            if(k != j) {
                                if (result[k][j] != 0 && result[i][k] != 0) {
                                    int length = result[i][k] + result[k][j];
                                    if (initialLength == 0 || initialLength > length) {
                                        initialLength = length;
                                        changed = true;
                                    }
                                }
                            }
                        }
                    }
                    result[i][j] = initialLength;
                }
            }
        }
        int[] rt = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                rt[i] += result[i][j];
        }
        return rt;
    }
}

