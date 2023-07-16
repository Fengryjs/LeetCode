package _1481;

/**
 * 给你一个整数数组 arr 和一个整数 k 。现需要从数组中恰好移除 k 个元素，请找出移除后数组中不同整数的最少数目。
 * 示例 1：
 *
 * 输入：arr = [5,5,4], k = 1
 * 输出：1
 * 解释：移除 1 个 4 ，数组中只剩下 5 一种整数。
 * 示例 2：
 *
 * 输入：arr = [4,3,1,1,3,3,2], k = 3
 * 输出：2
 * 解释：先移除 4、2 ，然后再移除两个 1 中的任意 1 个或者三个 3 中的任意 1 个，最后剩下 1 和 3 两种整数。
 */

import java.util.*;

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int a : arr){
            count.put(a, count.getOrDefault(a, 0) + 1);
        }
        ArrayList<Integer> arrayList = new ArrayList<>(count.values());
        Collections.sort(arrayList);
        int length = arrayList.size();
        while (length > 0 && k >= arrayList.get(0)) {
            k = k - arrayList.get(0);
            arrayList.remove(0);
            length--;
        }
        return length;
    }
}