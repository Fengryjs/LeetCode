package _970;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> result = new HashSet<>();
        int small, large;
        if (x < y){
            small = x;
            large = y;
        } else {
            small = y;
            large = x;
        }
        int i = 0;
        int j = 0;
        if (large == 1){
            if (small == 0) {
                if (1 <= bound)
                    result.add(1);
            } else if (small == 1) {
                if (2 <= bound)
                    result.add(2);
            }
        } else while (Math.pow(large, j) <= bound){
            int y_j = (int) Math.pow(large, j);
            if (small == 1) {
                result.add(Integer.sum(small, y_j));
            } else if (small == 0) {
                result.add(Integer.sum(small, y_j));
            } else
                while (y_j + Math.pow(small, i) <= bound){
                    int x_i = (int) Math.pow(small, i);
                    result.add(Integer.sum(x_i, y_j));
                    i++;
                }
            i = 0;
            j++;
        }
        return new ArrayList<>(result);
    }
}