package _516;


class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                /**
                 * 不用对每个位置的字符串找到该位置的相同的那个，而是对这个位置之后的每个位置进行填表
                 char char_i = s.charAt(i);
                 int index = j;
                 while (index != i) {
                 if (s.charAt(index) == char_i)
                 break;
                 index--;
                 }

                 */
                if (s.charAt(i) == s.charAt(j))
                    // 相同的情况下判断是否加入这两个
                    dp[i][j] = Math.max(dp[i + 1][j - 1] + 2, dp[i + 1][j]);
                else
                    // 不相同的情况下，看舍弃前一个还是后一个
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        // 动态规划，将字符a放进去和不放进去的情况下的长度
        return dp[0][s.length() - 1];
    }
}