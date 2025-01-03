package _993;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    /**
     * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
     * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
     * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
     * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
     * 示例 1：
     * 输入：root = [1,2,3,4], x = 4, y = 3
     * 输出：false
     * 示例 2：
     * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
     * 输出：true
     * 示例 3：
     * 输入：root = [1,2,3,null,4], x = 2, y = 3
     * 输出：false
     * 提示：
     * 二叉树的节点数介于 2 到 100 之间。
     * 每个节点的值都是唯一的、范围为 1 到 100 的整数。
     * @param root
     * @param x
     * @param y
     * @return
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        int x_depth = -1;
        int y_depth = -1;
        Deque<TreeNode> tree = new ArrayDeque<>();
        Deque<Integer> depth = new ArrayDeque<>();
        tree.addLast(root);
        depth.addLast(0);
        while (!tree.isEmpty()){
            TreeNode node = tree.removeFirst();
            int dp = depth.removeFirst();
            if (node.left != null && node.right != null && ((node.left.val == x && node.right.val == y) || (node.left.val == y && node.right.val ==x)))
                return false;
            if (node.left != null) {
                tree.addLast(node.left);
                depth.addLast(dp + 1);
            }
            if (node.right != null) {
                tree.addLast(node.right);
                depth.addLast(dp + 1);
            }
            if (node.val == x) {
                x_depth =dp;
            }
            if (node.val == y) {
                y_depth = dp;
            }
            if (x_depth == y_depth && x_depth != -1)
                return true;
        }
        return false;
    }

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}