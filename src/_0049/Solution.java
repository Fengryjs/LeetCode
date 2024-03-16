package _0049;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, List<String>> map = new HashMap<>();
        // Key 可以不用hashmap，改用string
        for (String str : strs) {
            HashMap<Character, Integer> key = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (key.containsKey(c)) {
                    key.put(c, key.get(c) + 1);
                } else {
                    key.put(c, 1);
                }
            }
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> values = new ArrayList<>();
                values.add(str);
                map.put(key, values);
            }
        }
        return new ArrayList<>(map.values());
    }
}
