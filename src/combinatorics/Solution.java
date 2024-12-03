package combinatorics;

import jdk.nashorn.internal.objects.annotations.Function;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.Executors;

public class Solution {

    public int C_m_n(int m, int n){
        assert m >= n;
        long result = 1;
        for (int i = m - n + 1; i <= m; i++) {
            result = result * i / (i - (m - n));
        }
        return (int) result;
    }
    public int A_m_n(int m, int n) {
        assert m >= n;
        long result = 1;
        for (int i = 1; i <= m; i++) {
            result = result * i;
        }
        for (int i = 1; i <= m - n; i++) {
            result = result / i;
        }
        return (int) result;
    }
    /**
     * Leetcode 62
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
     * 问总共有多少条不同的路径？
     * 示例 1：
     * 输入：m = 3, n = 7
     * 输出：28
     * 示例 2：
     * 输入：m = 3, n = 2
     * 输出：3
     * 解释：
     * 从左上角开始，总共有 3 条路径可以到达右下角。
     * 1. 向右 -> 向下 -> 向下
     * 2. 向下 -> 向下 -> 向右
     * 3. 向下 -> 向右 -> 向下
     * 示例 3：
     * 输入：m = 7, n = 3
     * 输出：28
     * 示例 4：
     * 输入：m = 3, n = 3
     * 输出：6
     * 提示：
     * 1 <= m, n <= 100
     * 题目数据保证答案小于等于 2 * 109
     */
    public int uniquePaths(int m, int n) {
        return C_m_n((m - 1 + n - 1), m - 1);
    }

    /**
     * 有 buckets 桶液体，其中 正好有一桶 含有毒药，其余装的都是水。它们从外观看起来都一样。为了弄清楚哪只水桶含有毒药，你可以喂一些猪喝，通过观察猪是否会死进行判断。不幸的是，你只有 minutesToTest 分钟时间来确定哪桶液体是有毒的。
     * 喂猪的规则如下：
     * 选择若干活猪进行喂养
     * 可以允许小猪同时饮用任意数量的桶中的水，并且该过程不需要时间。
     * 小猪喝完水后，必须有 minutesToDie 分钟的冷却时间。在这段时间里，你只能观察，而不允许继续喂猪。
     * 过了 minutesToDie 分钟后，所有喝到毒药的猪都会死去，其他所有猪都会活下来。
     * 重复这一过程，直到时间用完。
     * 给你桶的数目 buckets ，minutesToDie 和 minutesToTest ，返回 在规定时间内判断哪个桶有毒所需的 最小 猪数 。
     * 示例 1：
     * 输入：buckets = 1000, minutesToDie = 15, minutesToTest = 60
     * 输出：5
     * 示例 2：
     * 输入：buckets = 4, minutesToDie = 15, minutesToTest = 15
     * 输出：2
     * 示例 3：
     * 输入：buckets = 4, minutesToDie = 15, minutesToTest = 30
     * 输出：2
     * 提示：
     * 1 <= buckets <= 1000
     * 1 <= minutesToDie <= minutesToTest <= 100
     * @param buckets
     * @param minutesToDie
     * @param minutesToTest
     * @return
     */
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int circle = minutesToTest / minutesToDie;
        Executors.newSingleThreadScheduledExecutor();
        return 1;
    }

    /**
     * 给你两个正整数 n 和 limit 。
     * 请你将 n 颗糖果分给 3 位小朋友，确保没有任何小朋友得到超过 limit 颗糖果，请你返回满足此条件下的 总方案数 。
     * 示例 1：
     * 输入：n = 5, limit = 2
     * 输出：3
     * 解释：总共有 3 种方法分配 5 颗糖果，且每位小朋友的糖果数不超过 2 ：(1, 2, 2) ，(2, 1, 2) 和 (2, 2, 1) 。
     * 示例 2：
     * 输入：n = 3, limit = 3
     * 输出：10
     * 解释：总共有 10 种方法分配 3 颗糖果，且每位小朋友的糖果数不超过 3 ：(0, 0, 3) ，(0, 1, 2) ，(0, 2, 1) ，(0, 3, 0) ，(1, 0, 2) ，(1, 1, 1) ，(1, 2, 0) ，(2, 0, 1) ，(2, 1, 0) 和 (3, 0, 0) 。
     * 提示：
     * 1 <= n <= 50
     * 1 <= limit <= 50
     * @param n
     * @param limit
     * @return
     */
    public int distributeCandies(int n, int limit) {
        int result = 0;
        for (int i = 0; i <= limit; i++) {
            if (n - i <= 2 * limit && n - i <= limit) {
                result += n - i - limit + 1;
            } else if (n - i >= 0 && n - i < limit) {
                result += n - i + 1;
            }
        }
        return result;
    }
}
