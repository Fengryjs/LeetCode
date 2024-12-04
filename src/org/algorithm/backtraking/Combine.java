package org.algorithm.backtraking;
import java.util.ArrayList;
import java.util.List;
/**
 * 77. 组合
 * 中等
 *
 * 相关标签
 * 相关企业
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * 示例 2：
 *
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 *
 *
 * 提示：
 *
 * 1 <= n <= 20
 * 1 <= k <= n
 */
public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            backtracking(res, list, i + 1, n, k);
        }
        return res;
    }

    public void backtracking(List<List<Integer>> res, List<Integer> list, int i, int n, int k) {
        if (list.size() == k) {
            res.add(list);
            return;
        }
        for (int j = i; j <= n; j++) {
            List<Integer> l = new ArrayList<>(list);
            l.add(j);
            backtracking(res, l, j + 1, n, k);
        }
    }
}
