package _0056;

import java.util.*;

public class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        queue.addAll(Arrays.asList(intervals));
        int[] current = queue.poll();
        while (!queue.isEmpty()) {
            int[] interval = queue.poll();
            if (interval[0] <= current[1])
                current[1] = Math.max(interval[1], current[1]);
            else {
                result.add(current.clone());
                current = interval;
            }
        }
        result.add(current);
        int[][] resultArray = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }
}
