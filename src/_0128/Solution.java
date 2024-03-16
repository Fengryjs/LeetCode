package _0128;

import java.util.*;

public class Solution {
    /**
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
     * 示例 1：
     * 输入：nums = [100,4,200,1,3,2]
     * 输出：4
     * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
     * 示例 2：
     * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
     * 输出：9
     * 提示：
     * 0 <= nums.length <= 105
     * -109 <= nums[i] <= 109
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums)
            set.add(num);
        int maxStep = 0;
        for (int num: set) {
            if (!set.contains(num - 1)) {
                int step = 1;
                while (set.contains(num + step))
                    step++;
                maxStep = Math.max(step, maxStep);
            }
        }
        return maxStep;
//        class Interval {
//            int max;
//            int min;
//            public Interval(int min, int max) {
//                this.max = max;
//                this.min = min;
//            }
//        }
//        List<Interval> intervals = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            boolean processed = false;
//            for (int j = 0; j < intervals.size(); j++) {
//                Interval interval = intervals.get(j);
//                if (interval.min > nums[i] + 1) {
//                    intervals.add(j, new Interval(nums[i], nums[i] + 1));
//                    processed = true;
//                    break;
//                } else if (interval.min == nums[i] + 1) {
//                    interval.min--;
//                    if (j != 0 && intervals.get(j - 1).max == interval.min) {
//                        intervals.get(j - 1).max = interval.max;
//                        intervals.remove(interval);
//                    }
//                    processed = true;
//                    break;
//                } else if (interval.max == nums[i]) {
//                    interval.max++;
//                    if (j != intervals.size() - 1 && intervals.get(j + 1).min == interval.max) {
//                        intervals.get(j + 1).min = interval.min;
//                        intervals.remove(interval);
//                    }
//                    processed = true;
//                    break;
//                } else if (interval.min <= nums[i] && interval.max > nums[i]) {
//                    processed = true;
//                    break;
//                }
//            }
//            if (!processed)
//                intervals.add(new Interval(nums[i], nums[i] + 1));
//        }
//        int maxStep = 0;
//        for (Interval interval : intervals) {
//            if (interval.max - interval.min > maxStep) {
//                maxStep = interval.max - interval.min;
//                System.out.println("min " + interval.min + " max " + interval.max);
//            }
//        }
//        return maxStep;
    }


}
