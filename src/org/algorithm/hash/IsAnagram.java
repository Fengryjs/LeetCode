package org.algorithm.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的
 * 字母异位词
 * 。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 *
 * 提示:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t 仅包含小写字母
 *
 *
 * 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> sChar = new HashMap<>();
        Map<Character, Integer> tChar = new HashMap<>();
        for (Character c: s.toCharArray()) {
            sChar.put(c, sChar.getOrDefault(c, 0) + 1);
        }
        for (Character c: t.toCharArray()) {
            tChar.put(c, tChar.getOrDefault(c, 0) + 1);
        }
        return sChar.equals(tChar);
    }
}
