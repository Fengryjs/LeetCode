package _98;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [2,1,3]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：root = [5,1,4,null,null,3,6]
 * 输出：false
 * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
 *
 *
 * 提示：
 *
 * 树中节点数目范围在[1, 104] 内
 * -231 <= Node.val <= 231 - 1
 *
 * 解法较为复杂，可以考虑 validate(TreeNode root, minValue, maxValue)
 * minValue 初始定义为 int 类型边界值
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root.left == null && root.right == null)
            return true;
        if (root.left == null)
            return root.val < minVal(root.right) && isValidBST( root.right);
        if (root.right == null)
            return root.val > maxVal(root.left) && isValidBST(root.left);
        if (root.val > maxVal(root.left) && root.val < minVal(root.right))
            return isValidBST(root.left) && isValidBST(root.right);
        return false;
    }

    public int maxVal(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
        if (root.left == null)
            return Math.max(root.val, maxVal(root.right));
        if (root.right == null)
            return Math.max(root.val, maxVal(root.left));
        return Math.max(Math.max(maxVal(root.left), maxVal(root.right)), root.val);
    }

    public int minVal(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
        if (root.left == null)
            return Math.min(root.val, minVal(root.right));
        if (root.right == null)
            return Math.min(root.val, minVal(root.left));
        return Math.min(Math.min(minVal(root.left), minVal(root.right)), root.val);
    }
}
