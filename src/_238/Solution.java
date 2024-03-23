package _238;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] beforeSum = new int[nums.length];
        int before = 1;
        int[] afterSum = new int[nums.length];
        int after = 1;
        for (int i = 0; i < nums.length; i++) {
                beforeSum[i] = before;
                before = before * nums[i];
                afterSum[nums.length - 1 - i] = after;
                after = after * nums[nums.length - 1 - i];
        }
        for (int i = 0; i < nums.length; i++)
            result[i] = beforeSum[i] * afterSum[i];
        return result;
    }
}
