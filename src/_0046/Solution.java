package _0046;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] filled = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            filled[i] = -1;
        backTrack(result, nums, filled, 0);
        return result;
    }

    public void backTrack(List<List<Integer>> result, int[] nums, int[] filled, int n) {
        if (n == nums.length) {
            result.add(generateList(nums, filled));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (filled[i] == -1) {
                    filled[i] = n;
                    backTrack(result, nums, filled, n);
                    filled[i] = -1;
                } else {
                    continue;
                }
            }
        }

    }

    public List<Integer> generateList(int[] nums, int[] filled) {
        List<Integer> res = new ArrayList<>();
        for (int j : filled) res.add(nums[j]);
        return res;
    }
}
