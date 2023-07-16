package _1033;

import java.util.Arrays;

class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int[] args = new int[3];
        Arrays.sort(args);
//
//        args[0] = a;
//        args[1] = b;
//        args[2] = c;
//        for (int i = 0; i < 2; i++)
//            for (int j = 0; j < 2; j++)
//                if (args[j] > args[j + 1]) {
//                    int temp = args[j];
//                    args[j] = args[j + 1];
//                    args[j + 1] = temp;
//                }
//
//        System.out.println(args[0]);
//        System.out.println(args[1]);
//        System.out.println(args[2]);
        int[] result = new int[2];
        if (args[2] - args[1] == 1 && args[1] - args[0] == 1) {
            result[0] = 0;
        } else if (args[2] - args[1] == 1 || args[1] - args[0] == 1 || args[2] - args[1] == 2 || args[1] - args[0] == 2) {
            result[0] = 1;
        } else {
            result[0] = 2;
        }
        result[1] = args[2] - args[0] - 2;
        return result;
    }
}