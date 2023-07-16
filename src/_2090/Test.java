package _2090;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1000};
        int k = 10000000;
        int[] result = solution.getAverages(nums, k);
        System.out.println(Arrays.toString(Arrays.stream(result).toArray()));
    }

}
