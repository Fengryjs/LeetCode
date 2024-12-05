package org.algorithm.backtraking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        List<String> curRes = new ArrayList<>();
        backtracking(res, curRes, s, 0);
        return res;
    }

    public void backtracking(List<String> res, List<String>  curRes, String s, int index) {
        if (curRes.size() == 4) {
            if (index == s.length()) {
                res.add(toString(curRes));
            }
            return;
        }
        for (int i = index + 1; i <= s.length() && i <= index + 3; i++) {
            if ((s.charAt(index) != '0' && Integer.parseInt(s.substring(index, i)) <= 255) || (i == index + 1)) {
                curRes.add(s.substring(index, i));
                backtracking(res, curRes, s, i);
                curRes.remove(curRes.size() - 1);
            }
        }
    }

    public String toString(List<String> res) {
        assert res.size() == 4;
        StringBuilder builder = new StringBuilder();
        for (String s : res) {
            builder.append(s);
            builder.append(".");
        }
        return builder.deleteCharAt(builder.length() - 1).toString();
    }
}
