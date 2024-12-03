package _0005;

import java.util.HashSet;

public class Solution {
    /**
     * babad
     * [[1, 0, 0, 0, 0]         [[1, 0, 0, 0, 0]
     *  [0, 1, 0, 0, 0]          [0, 1, 0, 0, 0]
     *  [0, 0, 1, 0, 0] =>       [0, 0, 1, 0, 0]
     *  [0, 0, 0, 1, 0]          [0, 0, 0, 1, 0]
     *  [0, 0, 0, 0, 1]]         [0, 0, 0, 0, 1]]
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        // 动态规划法
        int[][] dp = new int[s.length()][s.length()];
        String longestPalindromeStr = "";
        // 遍历顺序，先初始化所有的 i，i，即单个字符，必然是
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
            longestPalindromeStr = s.substring(i, i + 1);
        }
        // 再初始化所有的 i,i + 1两个字符的，可能是可能不是
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                dp[i - 1][i] = 1;
                longestPalindromeStr = s.substring(i - 1, i + 1);
            }

        }
        // 再从长度为3的，一直到长度为n的，判断是不是
        for (int i = 2; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++){
                if (s.charAt(j - i) == s.charAt(j) && dp[j - i + 1][j - 1] == 1) {
                    dp[j - i][j] = 1;
                    longestPalindromeStr = s.substring(j - i, j + 1);
                }
            }
        }
//        Hash    Set
        return longestPalindromeStr;
    }

    // 中心扩展法
}
