package _0053;

import java.util.Arrays;

public class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        // 0 表示前面一个加进来
        // 1 表示前面的不要，从现在开始加；
        int result = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
