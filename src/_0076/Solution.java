package _0076;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String minWindowSolution1(String s, String t) {
        // 用前缀和能过265/267个测试用例
        List<int[]> dp = new ArrayList<>();
        int[] alphas = new int[52];
        int[] tAlpha = new int[52];
        dp.add(alphas.clone());
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) - 'a' >= 0) {
                tAlpha[t.charAt(i) - 'a' + 26] += 1;
            } else {
                tAlpha[t.charAt(i) - 'A'] += 1;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - 'a' >= 0) {
                alphas[s.charAt(i) - 'a' + 26] += 1;
            } else
                alphas[s.charAt(i) - 'A'] += 1;
            int[] copy = alphas.clone();
            dp.add(copy);
        }
        int minWindowLeft = -1;
        int minWindowRight = s.length() + 1;
        for (int i = dp.size() - 1; i >= 0; i--) {
            boolean more = false;
            for (int j = 0; j <= i; j++) {
                int[] right = dp.get(i);
                int[] left = dp.get(j);
                boolean subMore = true;
                for (int k = 0; k < 52; k++) {
                    if (right[k] - left[k] < tAlpha[k]) {
                        subMore = false;
                        break;
                    }
                }
                if (subMore == true) {
                    more = true;
                    if (i - j < minWindowRight - minWindowLeft) {
                        minWindowRight = i;
                        minWindowLeft = j;
                        if (i - j == t.length())
                            return s.substring(j, i);
                    }
                }
            }
            if (more == false)
                break;
        }
        if (minWindowLeft == -1)
            return "";
        else
            return s.substring(minWindowLeft, minWindowRight);
    }

    public String minWindowSolution2(String s, String t) {
        int left = 0;
        int right = 0;
        int[] tAlpha = new int[52];
        int[] sAlpha = new int[52];
        int minLeft = -1;
        int minRight = s.length();
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) - 'a' >= 0) {
                tAlpha[t.charAt(i) - 'a' + 26] += 1;
            } else {
                tAlpha[t.charAt(i) - 'A'] += 1;
            }
        }
        while (right < s.length() || left < s.length()) {
            boolean contains = true;
            for (int k = 0; k < 52; k++) {
                if (sAlpha[k] < tAlpha[k]) {
                    contains = false;
                    break;
                }
            }
            if (contains) {
                if (right - left < minRight - minLeft) {
                    minRight = right;
                    minLeft = left;
                }
            }
            if (contains) {
                if (s.charAt(left) - 'a' >= 0) {
                    sAlpha[s.charAt(left) - 'a' + 26] -= 1;
                } else {
                    sAlpha[s.charAt(left) - 'A'] -= 1;
                }
                // remove left
                left = left + 1;
            } else {
                // add right
                if (right == s.length()) {
                    break;
                }
                if (s.charAt(right) - 'a' >= 0) {
                    sAlpha[s.charAt(right) - 'a' + 26] += 1;
                } else {
                    sAlpha[s.charAt(right) - 'A'] += 1;
                }
                right = right + 1;
            }
        }
        if (minLeft == -1) {
            return "";
        } else
            return s.substring(minLeft, minRight);
    }
}
