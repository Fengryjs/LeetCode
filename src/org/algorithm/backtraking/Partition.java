package org.algorithm.backtraking;

import java.util.ArrayList;
import java.util.List;

public class Partition {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtracking(res, new ArrayList<>(), s, 0);
        return res;
    }
    public void backtracking(List<List<String>> res, List<String> curRes, String s, int begin) {
        if (begin == s.length()) {
            res.add(new ArrayList<>(curRes));
            return;
        }
        for (int i = begin + 1; i <= s.length(); i++) {
            if (isReverseSame(s.substring(begin, i))) {
                curRes.add(s.substring(begin, i));
                backtracking(res, curRes, s, i);
                curRes.remove(curRes.lastIndexOf(s.substring(begin, i)));
            }
        }
    }

    public boolean isReverseSame(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
