package org.algorithm.binaryTree;

import org.algorithm.Pair;

/**
 * 513. 找树左下角的值
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 *
 * 假设二叉树中至少有一个节点。
 * 示例 1:
 * 输入: root = [2,1,3]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 * 提示:
 * 二叉树的节点个数的范围是 [1,104]
 * -231 <= Node.val <= 231 - 1
 */
public class FindBottomLeftValue {
    public int findBottomLeftValue(TreeNode root) {
        Pair<Integer, Integer> res = findDepthAndValue(root);
        return res.getRight();
    }

    /**
     *
     * @param node
     * @return < Depth, Value >
     */
    public Pair<Integer, Integer> findDepthAndValue(TreeNode node) {
        if (node == null) {
            return new Pair<>(-1, null);
        }
        Pair<Integer, Integer> left = findDepthAndValue(node.left);
        Pair<Integer, Integer> right = findDepthAndValue(node.right);
        if (node.left == null && node.right == null) {
            return new Pair<>(0, node.val);
        }
        if (left.getLeft() >= right.getLeft()) {
            return new Pair<>(left.getLeft() + 1, left.getRight());
        } else {
            return new Pair<>(right.getLeft() + 1, right.getRight());
        }
    }
}
