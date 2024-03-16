package _0438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    /**
     * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
     * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）
     * 示例 1:
     * 输入: s = "cbaebabacd", p = "abc"
     * 输出: [0,6]
     * 解释:
     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
     *  示例 2:
     * 输入: s = "abab", p = "ab"
     * 输出: [0,1,2]
     * 解释:
     * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
     * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
     * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
     * 提示:
     * 1 <= s.length, p.length <= 3 * 104
     * s 和 p 仅包含小写字母
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length())
            return result;
        HashMap<Character, Integer> pMap = new HashMap<>();
        HashMap<Character, Integer> subsMap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            Integer num = pMap.getOrDefault(p.charAt(i), 0);
            Integer sNum = subsMap.getOrDefault(s.charAt(i), 0);
            pMap.put(p.charAt(i), num + 1);
            subsMap.put(s.charAt(i), sNum + 1);
        }
        if (pMap.equals(subsMap))
            result.add(0);
        for (int i = p.length(); i < s.length(); i++) {
            char deletedChar = s.charAt(i - p.length());
            Integer deletedNum = subsMap.get(deletedChar);
            if (deletedNum == 1) {
                subsMap.remove(deletedChar);
            } else {
                subsMap.put(deletedChar, deletedNum - 1);
            }
            char insertedChar = s.charAt(i);
            Integer insertedNum = subsMap.getOrDefault(insertedChar, 0);
            subsMap.put(insertedChar, insertedNum + 1);
            if (pMap.equals(subsMap))
                result.add(i - p.length());
        }
        return result;
    }
}
