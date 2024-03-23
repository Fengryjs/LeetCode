package _0078;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        int[] filled = new int[nums.length];
        backTrack(result, nums, filled, 0);
        return result;
    }

    public void backTrack(List<List<Integer>> result, int[] nums, int[] filled, int n) {
        if (n == nums.length)
            result.add(generateList(nums, filled));
        else {
            backTrack(result, nums, filled, n + 1);
            filled[n] = 1;
            backTrack(result, nums, filled, n + 1);
            filled[n] = 0;
        }

    }
    public List<Integer> generateList(int[] nums, int[] filled) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (filled[i] == 1) {
                res.add(nums[i]);
            }
        }
        return res;
    }
}
