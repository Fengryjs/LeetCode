package _0001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{i, hashMap.get(target - nums[i])};
            }
            hashMap.put(nums[i], i);
        }
        return null;
    }
}
