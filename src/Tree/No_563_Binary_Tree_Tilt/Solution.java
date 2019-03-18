package Tree.No_563_Binary_Tree_Tilt;

import Tree.TreeNode;

/**
 * FileName: Solution
 * Author:   mac
 * Date:     2019-03-18 13:38
 * Description: Binary Tree Tilt
 * Given a binary tree, return the tilt of the whole tree.
 * <p>
 * The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.
 * <p>
 * The tilt of the whole tree is defined as the sum of all nodes' tilt.
 * <p>
 * Example:
 * Input:
 * 1
 * /   \
 * 2     3
 * Output: 1
 * Explanation:
 * Tilt of node 2 : 0
 * Tilt of node 3 : 0
 * Tilt of node 1 : |2-3| = 1
 * Tilt of binary tree : 0 + 0 + 1 = 1
 * Note:
 * <p>
 * The sum of node values in any subtree won't exceed the range of 32-bit integer.
 * All the tilt values won't exceed the range of 32-bit integer.
 */

public class Solution {
    int sum = 0;

    public int findTilt(TreeNode root) {

        handle(root);

        return sum;
    }

    private int handle(TreeNode root) {
        if (root == null) return 0;

        int left = handle(root.left);

        int right = handle(root.right);

        sum += Math.abs(left - right);

        return root.val + left + right; //返回 左右子树加上 本身根
    }
}
