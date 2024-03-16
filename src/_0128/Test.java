package _0128;

public class Test {


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{-2,-3,-3,7,-3,0,5,0,-8,-4,-1,2};
        int maxStep = solution.longestConsecutive(nums);
        System.out.println(maxStep);
    }
}
