package Tree.easy.No_669_Trim_a_Binary_Search_Tree;

import Tree.TreeNode;

/**
 * FileName: Solution
 * Author:   mac
 * Date:     2019-03-04 13:56
 * Description: Trim a Binary Search Tree
 * Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.
 *
 * Example 1:
 * Input:
 *     1
 *    / \
 *   0   2
 *
 *   L = 1
 *   R = 2
 *
 * Output:
 *     1
 *       \
 *        2
 * Example 2:
 * Input:
 *     3
 *    / \
 *   0   4
 *    \
 *     2
 *    /
 *   1
 *
 *   L = 1
 *   R = 3
 *
 * Output:
 *       3
 *      /
 *    2
 *   /
 *  1
 */
public class Solution {
    //节点值 在[L,R]范围内
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return root;
        if (root.val > R) return trimBST(root.left, L, R); //数值大于最大的 则右子树一定也是大于R的
        if (root.val < L) return trimBST(root.right, L, R);//同理

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);

        return root;
    }
}
