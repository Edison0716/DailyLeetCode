package Tree.No_110_Balanced_Binary_Tree;

import Tree.TreeNode;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-03-27 11:26
 * Description: Balanced Binary Tree
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example 1:
 *
 * Given the following tree [3,9,20,null,null,15,7]:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Return true.
 *
 * Example 2:
 *
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * Return false.
 */

public class Solution {
    private boolean res = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        handleBalanced(root);
        return res;
    }

    private int handleBalanced(TreeNode node) {
        if (node == null) return 0;
        int l = handleBalanced(node.left);
        int r = handleBalanced(node.right);
        if (Math.abs(l - r) > 1)
            res = false;
        return 1 + Math.max(l, r);
    }


    public boolean isBalanced1(TreeNode root) {
        if (root == null) return true;

        else {
            int l = dfs(root.left);
            int r = dfs(root.right);
            if (l - r > 1 || l - r < -1)
                return false;
            else
                return isBalanced1(root.left) && isBalanced1(root.right);
        }
    }


    private int dfs(TreeNode node) {
        if (node == null) return 0;
        else {
            int l = dfs(node.left) + 1;
            int r = dfs(node.right) + 1;
            return l > r ? l : r;
        }
    }

}
