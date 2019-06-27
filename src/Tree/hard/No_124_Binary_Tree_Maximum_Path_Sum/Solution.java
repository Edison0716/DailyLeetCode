package Tree.hard.No_124_Binary_Tree_Maximum_Path_Sum;

import Tree.TreeNode;

/**
 * FileName: Solution
 * Author:   EdisonLi的Windows
 * Date:     2019/6/27 16:36
 * Description:
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * Output: 6
 * Example 2:
 *
 * Input: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Output: 42
 * Difficulty: Hard
 */
public class Solution {
    private int resMaxValue;

    public int maxPathSum(TreeNode root) {
        resMaxValue = Integer.MIN_VALUE;
        handleNode(root);
        return resMaxValue;
    }

    private int handleNode(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, handleNode(node.left));
        int right = Math.max(0, handleNode(node.right));
        resMaxValue = Math.max(resMaxValue, left + right + node.val);
        return Math.max(left,right) + node.val;
    }
}
