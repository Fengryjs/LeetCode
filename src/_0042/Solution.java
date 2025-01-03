package _0042;

public class Solution {
    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * 示例 1：
     * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出：6
     * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
     * 示例 2：
     * 输入：height = [4,2,0,3,2,5]
     * 输出：9
     * 提示：
     * n == height.length
     * 1 <= n <= 2 * 104
     * 0 <= height[i] <= 105
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height.length <= 2)
            return 0;
        int volume = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right - 1) {
            if (height[left] < height[right]) {
                int step = 1;
                while (height[left + step] < height[left]) {
                    volume += height[left] - height[left + step];
                    step += 1;
                }
                left = left + step;
            } else {
                int step = 1;
                while (height[right - step] < height[right]) {
                    volume += height[right] - height[right - step];
                    step += 1;
                }
                right = right - step;
            }
        }
        return volume;
    }
}
