package _0215;

public class Test {


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        int k = 2;
        int result = solution.findKthLargest(nums, k);
        System.out.println(result);
    }
}
