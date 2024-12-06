package org.algorithm.combination;

public class Combination {
    public static long cMN(int m, int n) {
        long res = 1;
        for (long i = m - n + 1; i <= m; i++) {
            res = res * i;
            res = res / (i - (m - n));
        }
        return (int) res;
    }
}
