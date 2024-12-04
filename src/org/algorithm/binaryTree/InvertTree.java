package org.algorithm.binaryTree;

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        } else {
            TreeNode right = root.right;
            root.right = root.left;
            root.left = right;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }
}
