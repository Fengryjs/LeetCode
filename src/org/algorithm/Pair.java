package org.algorithm;

public class Pair <L, R> {
    L left;
    R right;

    public Pair(L l, R r) {
        this.left = l;
        this.right = r;
    }

    public L getLeft() {
        return this.left;
    }

    public R getRight() {
        return this.right;
    }
}
