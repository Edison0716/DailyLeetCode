package Tree.medium.No_1026_Maximum_Difference_Between_Node_and_Ancestor;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * FileName: Solution
 * Author:   EdisonLi的Windows
 * Date:     2019/5/24 13:41
 * Description: Maximum Difference Between Node and Ancestor
 * <p>
 * Given the root of a binary tree, find the maximum value V for which there exists different nodes A and B where V = |A.val - B.val| and A is an ancestor of B.
 * <p>
 * (A node A is an ancestor of B if either: any child of A is equal to B, or any child of A is an ancestor of B.)
 * <p>
 * Example 1:
 * <p>
 * Input: [8,3,10,1,6,null,14,null,null,4,7,13]
 * Output: 7
 * Explanation:
 * We have various ancestor-node differences, some of which are given below :
 * |8 - 3| = 5
 * |3 - 7| = 4
 * |8 - 1| = 7
 * |10 - 13| = 3
 * Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.
 * <p>
 * Difficulty: Medium
 */
public class Solution {
    public int maxAncestorDiff(TreeNode root) {
        return handleNode(root, root.val, root.val);
    }

    private int handleNode(TreeNode root, int nodeMin, int nodeMax) {
        if (root == null) return nodeMax - nodeMin;

        nodeMax = Math.max(nodeMax, root.val);
        nodeMin = Math.min(nodeMin, root.val);

        return Math.max(handleNode(root.left, nodeMin, nodeMax), handleNode(root.right, nodeMin, nodeMax));
    }


    /**************************之前我是这么写的 后来发现不是平衡二叉树*************************/
    private List<Integer> nodeContainer;
    private int rootNum = 0;

    public int maxAncestorDiff1(TreeNode root) {
        nodeContainer = new ArrayList<>();
        rootNum = root.val;
        handleNode(root);
        return Math.max(nodeContainer.get(nodeContainer.size() - 1) - rootNum,rootNum - nodeContainer.get(0));
    }

    private void handleNode(TreeNode root) {
        if (root == null) return;

        handleNode(root.left);

        nodeContainer.add(root.val);

        handleNode(root.right);
    }
}
