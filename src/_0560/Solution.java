package _0560;

import java.util.HashMap;

public class Solution {
    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。子数组是数组中元素的连续非空序列。
     * 示例 1：
     * 输入：nums = [1,1,1], k = 2
     * 输出：2
     * 示例 2：
     * 输入：nums = [1,2,3], k = 3
     * 输出：2
     * 提示：
     * 1 <= nums.length <= 2 * 104
     * -1000 <= nums[i] <= 1000
     * -107 <= k <= 107
     * @param nums
     * @param k
     * @return
     */
    public int subarraySumSolution1(int[] nums, int k) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k)
                    result += 1;
            }
        }
        return result;
    }
    public int subarraySumSolution2(int[] nums, int k) {
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                result += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return result;
    }
}
