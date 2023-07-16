package _1889;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int minWastedSpace(int[] packages, int[][] boxes) {
        long result = -1;
        Arrays.sort(packages);
        int max = packages[packages.length - 1];
        for (int i = 0; i < boxes.length; i++) {
            Arrays.sort(boxes[i]);
            if (boxes[i][boxes[i].length - 1] < max)
                continue;
            else {
                long waste = 0;
                int boxes_index = 0;
                //
                for (int aPackage : packages) {
                    while (boxes[i][boxes_index] < aPackage)
                        boxes_index++;
                    waste += boxes[i][boxes_index] - aPackage;
                }
                if (result == -1)
                    result = waste;
                else if (result > waste) {
                    result = waste;
                }
            }
        }
        return (int) (result % ((long) (10e8 + 7)));
    }
}