package study;

import java.util.*;

public class Solution {
    /**
     * 写一个函数，在一个字符串中查找一个最长的不包含重复字符的子串
     * @return
     */
    public String fun(String s){
        // Key： 字符， Value： 上一次出现的位置。
        HashMap<Character, Integer> map = new HashMap<>();
        int index = 0;
        int currentLeft = 0;
        int maxLengthRight = 0;
        int maxLengthLeft = 0;
        while (index != s.length()) {
            Character key = s.charAt(index);
            if (map.containsKey(key)) {
                if (map.get(key) < currentLeft) {
                    map.put(key, index);
                } else {
                    currentLeft = map.get(key) + 1;
                    map.put(key, index);
                }
            } else {
                map.put(key, index);
            }
            if (index - currentLeft >= maxLengthRight - maxLengthLeft) {
                maxLengthRight = index;
                maxLengthLeft = currentLeft;
            }
            index++;
        }
        return s.substring(maxLengthLeft, maxLengthRight + 1);
    }

    /**
     * 输入：n=2
     * 输出：
     * 1
     * 1    1
     * 1    2    1
     * 1    3    3    1
     * 1    4    6    4     1
     */
    public void yanghuiTangle(int n) {
//        List<Integer> list = new ArrayList<>();
//        System.out.println(1);
//        list.add(1);
//        for (int i = 1; i <= n; i++) {
//            System.out.print(1 + " ");
//            list.add(1);
//            for (int j = 1; j < i; j++) {
//                int before = list.get((i - 1) * (i) / 2 + j - 1 );
//                int next = list.get((i - 1) * i / 2 + j);
//                System.out.print((before + next) + " ");
//                list.add(before + next);
//            }
//            System.out.println(1);
//            list.add(1);
//        }
        int[][] nums = new int[n + 1][n + 1];
        nums[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i){
                    nums[i][j] = 1;
                } else {
                    nums[i][j] = nums[i-1][j - 1] + nums[i-1][j];
                }
            }
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (nums[i][j] != 0)
                    System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (map.containsKey( - nums[j] - nums[i])) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(- nums[i] - nums[j]);
                    Collections.sort(list);
                    result.add(list);
                }
            }
            map.put(nums[i], i);
        }
        return new ArrayList<>(result);
    }
}
