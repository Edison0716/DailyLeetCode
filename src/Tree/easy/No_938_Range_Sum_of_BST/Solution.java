package Tree.easy.No_938_Range_Sum_of_BST;

import Tree.TreeNode;

/**
 * FileName: Solution
 * Author:   EdisonLi的Windows
 * Date:     2019/5/28 15:24
 * Description: Range Sum of BST
 * Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).
 * <p>
 * The binary search tree is guaranteed to have unique values.
 * <p>
 * Example 1:
 * <p>
 * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
 * Output: 32
 * Example 2:
 * <p>
 * Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * Output: 23
 * <p>
 * <p>
 * Note:
 * <p>
 * The number of nodes in the tree is at most 10000.
 * The final answer is guaranteed to be less than 2^31.
 * <p>
 * Difficulty: Easy
 */
public class Solution {
    private int mResult = 0;

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;
        handleNode(root, L, R);
        return mResult;
    }

    private void handleNode(TreeNode root, int L, int R) {
        if (root == null) return;

        handleNode(root.left, L, R);

        if (root.val >= L && root.val <= R)
            mResult += root.val;

        handleNode(root.right, L, R);
    }
}
