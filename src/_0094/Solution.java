package _0094;

import SimpleDataStruct.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return Collections.emptyList();
        List<Integer> result = new ArrayList<>();
        result.add(root.val);
        result.addAll(inorderTraversal(root.left));
        result.addAll(inorderTraversal(root.right));
        return result;
    }
}
