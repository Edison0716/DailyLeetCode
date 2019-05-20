package Tree.easy.No_530_Minimum_Absolute_Difference_in_BST;


import Tree.TreeNode;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-05-20 22:08
 * Description: Minimum Absolute Difference in BST
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 * 1
 * \
 * 3
 * /
 * 2
 * <p>
 * Output:
 * 1
 * <p>
 * Explanation:
 * The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 */
public class Solution {
    int min = Integer.MAX_VALUE;
    TreeNode per;

    public int getMinimumDifference(TreeNode root) {
        handle(root);
        return min;
    }

    private void handle(TreeNode root) {
        if (root == null) return;

        handle(root.left);

        //先序遍历
        if (per != null) min = Math.min(min, root.val - per.val);
        per = root;

        handle(root.right);
    }

}
