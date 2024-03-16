package _0239;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

public class Solution {
    /**
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     * 返回 滑动窗口中的最大值 。
     * 示例 1：
     * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
     * 输出：[3,3,5,5,6,7]
     * 解释：
     * 滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     * 示例 2：
     *
     * 输入：nums = [1], k = 1
     * 输出：[1]
     * 提示：
     * 1 <= nums.length <= 105
     * -104 <= nums[i] <= 104
     * 1 <= k <= nums.length
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        // PriorityQueue未优化时的方法
        // remove为O(n)复杂度
        class Position {
            int value;
            int index;
            public Position(int value, int index) {
                this.value = value;
                this.index = index;
            }
        }
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<Position> window = new PriorityQueue<>(new Comparator<Position>() {
            @Override
            public int compare(Position o1, Position o2) {
                if (o1.value != o2.value )
                    return o1.value - o2.value;
                else
                    return o2.index - o1.index;
            }
        });
        for (int i = 0; i < k - 1; i++)
            window.add(new Position(nums[i], i));
        for (int i = 0; i < nums.length - k + 1; i++) {
            window.add(new Position(nums[i + k - 1], i + k - 1));
            Position first = window.peek();
            while (first.index < i) {
                window.remove(first);
                first = window.peek();
            }
            result[i] = first.value;

        }
        return result;
    }
}
