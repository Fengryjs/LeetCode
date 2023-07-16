package _1901;

public class Test {


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arg = new int[][]{
                {1,2,99,98,22,21,20},{2,3,4,6,7,8,19},{3,5,6,7,8,9,18},{4,6,7,8,9,10,17},{6,7,8,9,10,11,16},{7,8,9,10,11,12,15},{8,9,10,11,12,13,14}};
        int[] result = solution.findPeakGrid(arg);
    }
}
