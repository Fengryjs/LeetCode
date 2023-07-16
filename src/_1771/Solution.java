package _1771;

class Solution {
    public int longestPalindrome(String word1, String word2) {
        String total = word1 + word2;
        if (total.length() == 0)
            return 0;
        int[][] dp = new int[total.length()][total.length()];
        for (int i = total.length() - 1; i >= 0; i--)
            for (int j = 0; j < total.length(); j++){
                if (j < i){
                    dp[i][j] = 0;
                }
                else if (j == i)
                    dp[i][j] = 1;
                else {
                    char char_i = total.charAt(i);
                    int index = j;
                    while (index != i){
                        if (total.charAt(index) == char_i)
                            break;
                        index--;
                    }
                    if (index > i)
                        dp[i][j] = Math.max(dp[i + 1][index] + 1, dp[i + 1][j]);
                    else
                        dp[i][j] = dp[i + 1][j];
                }
            }
        System.out.println(dp[0][total.length() - 1]);

        // 动态规划，将字符a放进去和不放进去的情况下的长度
        return dp[0][total.length() - 1];
    }
}