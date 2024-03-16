package _0283;

public class Solution {
    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     * 示例 1:
     * 输入: nums = [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 示例 2:
     * 输入: nums = [0]
     * 输出: [0]
     * 提示:
     * 1 <= nums.length <= 104
     * -231 <= nums[i] <= 231 - 1
     */
    public void moveZeroes(int[] nums) {
        // TODO 应该是移动0，而不是覆盖0
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                zeroCount += 1;
            else {
                nums[i - zeroCount] = nums[i];
            }
        }
        for (int i = zeroCount; i > 0; i--) {
            nums[nums.length - i] = 0;
        }
    }
}
