package org.algorithm.array;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class IntervalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(new BufferedInputStream(System.in)));
        int len;
        int[] nums;
        int sum = 0;
        int[] sums;
        len = scanner.nextInt();
        nums = new int[len];
        sums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = scanner.nextInt();
            sum += nums[i];
            sums[i] = sum;
        }
        while (scanner.hasNext()) {
            String[] interval = scanner.next().split(" ");
            System.out.println(sums[Integer.parseInt(interval[1])] - sums[Integer.parseInt(interval[0])] + nums[Integer.parseInt(interval[0])]);
        }

    }
}
