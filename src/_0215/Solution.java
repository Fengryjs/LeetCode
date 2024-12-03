package _0215;

public class Solution {

    /**
     * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
     * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
     * 示例 1:
     * 输入: [3,2,1,5,6,4], k = 2
     * 输出: 5
     * 示例 2:
     * 输入: [3,2,3,1,2,4,5,5,6], k = 4
     * 输出: 4
     * 提示：
     * 1 <= k <= nums.length <= 105
     * -104 <= nums[i] <= 104
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, nums.length - k, 0, nums.length - 1);


    }
    public int quickSort(int[] nums, int k, int left, int right) {
        System.out.println("Sort begin " + left + " " + right);
        for (int num: nums)
            System.out.print(num + " ");
        System.out.println();
        if (left == right) return nums[k];
        int x = nums[left], i = left - 1, j = right + 1;
        while (i < j) {
            i++;
            j--;
            while (nums[i] < x)
                i++;
            while (nums[j] > x)
                j--;
            if (i < j){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        if (k <= j) return quickSort(nums, k, left, j);
        else return quickSort(nums, k, j + 1, right);
    }
}
