package _1889;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] packages = new int[]{3,5,8,10,11,12};
        int[][] boxes = new int[][]{{12},{11,9},{10,5,14}};
        int result = solution.minWastedSpace(packages, boxes);
        System.out.println(result);
    }
}
