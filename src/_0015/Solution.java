package _0015;

import java.util.*;

public class Solution {
    /**
     * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
     * 你返回所有和为 0 且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     * 示例 1：
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     * 解释：
     * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
     * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
     * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
     * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
     * 注意，输出的顺序和三元组的顺序并不重要。
     * 示例 2：
     * 输入：nums = [0,1,1]
     * 输出：[]
     * 解释：唯一可能的三元组和不为 0 。
     * 示例 3：
     * 输入：nums = [0,0,0]
     * 输出：[[0,0,0]]
     * 解释：唯一可能的三元组和为 0 。
     * 提示：
     * 3 <= nums.length <= 3000
     * -105 <= nums[i] <= 105
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // 双指针用在什么时候，两个东西的变化顺序是相反的，一定是一个减，一个增
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int i = 0;
        while (i < nums.length - 2) {
            if (nums[i] > 0) {
                break;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    List<Integer> sub = new ArrayList<>();
                    sub.add(nums[i]);
                    sub.add(nums[left]);
                    sub.add(nums[right]);
                    result.add(sub);
                    while (left < nums.length - 1 && nums[left] == nums[left + 1])
                        left++;
                    left++;
                    while (right > i && nums[right] == nums[right - 1])
                        right--;
                    right--;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    while (right > i && nums[right] == nums[right - 1])
                        right--;
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < 0) {

                    while (left < nums.length - 1 && nums[left] == nums[left + 1])
                        left++;
                    left++;
                }
            }
            while (i < nums.length - 2 && nums[i] == nums[i + 1])
                i++;
            i++;
        }
        return result;
//        Set<List<Integer>> result = new HashSet<>();
//        for (int i = 0; i < nums.length - 2; i++) {
//            HashMap<Integer, Integer> map = new HashMap<>();
//            for (int j = i + 1; j < nums.length; j++) {
//                List<Integer> subList = new ArrayList<>();
//                subList.add(nums[i]);
//                if (map.containsKey(-nums[i] - nums[j])) {
//                    subList.add(nums[j]);
//                    subList.add(-nums[i] - nums[j]);
//                    Collections.sort(subList);
//                    result.add(subList);
//                }
//                map.put(nums[j], j);
//            }
//        }
//        return new ArrayList<>(result);
    }
}
