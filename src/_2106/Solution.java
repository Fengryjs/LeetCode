package _2106;

class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        // 可到达区域
        int begin_index = 0;
        int end_index = fruits.length - 1;
        int begin = startPos - k;
        int end = startPos;
        while (fruits[begin_index][0] < begin) {
            begin_index++;
            if (begin_index == fruits.length)
                return 0;
        }
        while (fruits[end_index][0] > end){
            end_index--;
            if (end_index == -1) {
                break;
            }
        }
        int current = 0;
        for (int i = begin_index; i <= end_index; i++) {
            current += fruits[i][1];
        }
        int max = current;
        while (end != startPos + k) {
            if (Math.abs(begin - startPos) > end + 2 - startPos) {
                end += 1;
                begin += 2;
            } else if (Math.abs(begin - startPos) == end + 2 - startPos) {
                end += 2;
                begin += 2;
            } else if (Math.abs(begin - startPos) == end + 1 - startPos) {
                end += 1;
                begin += 1;
            } else {
                end += 2;
                begin += 1;
            }
            while (fruits[begin_index][0] < begin) {
                current -= fruits[begin_index][1];
                begin_index += 1;
                if (begin_index == fruits.length)
                    return max;
            }
            if (end_index == fruits.length - 1)
                return max;
            while (fruits[end_index + 1][0] <= end) {
                end_index += 1;
                current += fruits[end_index][1];
                if (end_index == fruits.length - 1) {
                    if (current >= max)
                        max = current;
                    return max;
                }
            }
            if (current >= max)
                max = current;
        }
        return max;
    }
}