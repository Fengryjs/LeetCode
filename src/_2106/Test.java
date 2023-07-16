package _2106;



public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arg = new int[][]{
                {0,10},{1,6},{2,4},{8,10},{9,5},{13,3},{14,3},{23,4},{28,5},{29,7},{30,6},{32,2},{33,8},{36,4},{40,9}};
        int result = solution.maxTotalFruits(arg, 0, 23);
        System.out.println(result);
    }
}
