package _0076;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String minWindow(String s, String t) {
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
                            return s.substring(i, j);
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
}
