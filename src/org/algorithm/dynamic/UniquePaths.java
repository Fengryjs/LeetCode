package org.algorithm.dynamic;

import static org.algorithm.combination.Combination.cMN;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        return (int) cMN(m + n - 2, Math.min( n - 1, m - 1));
    }
}
