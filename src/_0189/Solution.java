package _0189;

import java.util.Arrays;

public class Solution {
    /**
     * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
     *
     *
     *
     * 示例 1:
     *
     * 输入: nums = [1,2,3,4,5,6,7], k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右轮转 1 步: [7,1,2,3,4,5,6]
     * 向右轮转 2 步: [6,7,1,2,3,4,5]
     * 向右轮转 3 步: [5,6,7,1,2,3,4]
     * 示例 2:
     *
     * 输入：nums = [-1,-100,3,99], k = 2
     * 输出：[3,99,-1,-100]
     * 解释:
     * 向右轮转 1 步: [99,-1,-100,3]
     * 向右轮转 2 步: [3,99,-1,-100]
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 105
     * -231 <= nums[i] <= 231 - 1
     * 0 <= k <= 105
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int temp;
        for (int i = 0; i < nums.length / 2; i++) {
            temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
        for (int i = 0; i < k / 2; i++) {
            temp = nums[i];
            nums[i] = nums[k - i];
            nums[k - i] = temp;
        }
        for (int i = k; i < k + nums.length / 2; i++) {
            temp = nums[i];
            nums[i] = nums[nums.length + 2 * k - i];
            nums[nums.length + 2 * k - i] = temp;
        }
    }
}
