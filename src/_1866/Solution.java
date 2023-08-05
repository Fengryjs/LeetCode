package _1866;

/**
 * 有 n 根长度互不相同的木棍，长度为从 1 到 n 的整数。请你将这些木棍排成一排，并满足从左侧 可以看到 恰好 k 根木棍。从左侧 可以看到 木棍的前提是这个木棍的 左侧 不存在比它 更长的 木棍。
 *
 * 例如，如果木棍排列为 [1,3,2,5,4] ，那么从左侧可以看到的就是长度分别为 1、3 、5 的木棍。
 * 给你 n 和 k ，返回符合题目要求的排列 数目 。由于答案可能很大，请返回对 109 + 7 取余 的结果。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3, k = 2
 * 输出：3
 * 解释：[1,3,2], [2,3,1] 和 [2,1,3] 是仅有的能满足恰好 2 根木棍可以看到的排列。
 * 可以看到的木棍已经用粗体+斜体标识。
 * 示例 2：
 *
 * 输入：n = 5, k = 5
 * 输出：1
 * 解释：[1,2,3,4,5] 是唯一一种能满足全部 5 根木棍可以看到的排列。
 * 可以看到的木棍已经用粗体+斜体标识。
 * 示例 3：
 *
 * 输入：n = 20, k = 11
 * 输出：647427950
 * 解释：总共有 647427950 (mod 109 + 7) 种能满足恰好有 11 根木棍可以看到的排列。
 */
public class Solution {
    // 一个很好的思路 插最小的
    public long rearrangeSticks(int n, int k) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++)
            dp[i][i] = 1;
        // 每次插最长的那个，插在 i 的位置，然后前面就必须是，i - 1 个，同时也必须只能看见 k - 1 个柱子
        long result = 0;
        if (n == k)
            return 1;
        if (k == 1)
            return jiec(n - 1);
        for (int i = k; i <= n; i++) {
            result +=  (rearrangeSticks(i - 1, k - 1) + (i - 1) * (rearrangeSticks(i - 1, k)));
        }
        return result % (1000000000 + 7);
    }

    public long c(int n, int k) {
        // System.out.println("C_" + n + "^" + k +"=" + jiec(n) / (jiec(n - k) * jiec(k)));
        return (jiec(n) / jiec(n - k)) / jiec(k);
    }

    public int jiec(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++)
            result = result * i;
        return result;
    }
}
