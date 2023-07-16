package _834;

public class Test {


    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 6;
//        int[][] edges = {};
        int[][] edges = {{0,1}, {0,2}, {2,3},{2,4},{2,5}};
        int[] result = solution.sumOfDistancesInTree(n, edges);
        for (int i = 0; i < n; i++)
            System.out.println(result[i]);
    }
}
