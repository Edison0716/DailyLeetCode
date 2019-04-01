package Tree.easy.No_687_Longest_Univalue_Path;


import Tree.TreeNode;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-03-30 21:46
 * Description: Longest Univalue Path
 * <p>
 * Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.
 * <p>
 * Note: The length of path between two nodes is represented by the number of edges between them.
 * <p>
 * Example 1:
 *
 * Input:
 *
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 * Output:
 *
 * 2
 * Example 2:
 *
 * Input:
 *
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 * Output:
 *
 * 2
 *
 * Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.
 */
public class Solution {
    int res = 0;

    public int longestUnivaluePath(TreeNode root) {

        handlePath(root);

        return res;
    }

    private int handlePath(TreeNode node) {
        if (node == null) return 0;

        //递归左右子树
        int left = handlePath(node.left);
        int right = handlePath(node.right);

        int arrLeft = 0, arrRight = 0;

        //判断是否与父节点相等 另外若左右两节点与父节点相同 则 左右要进行相加
        if (node.left != null && node.left.val == node.val) {
            arrLeft = arrLeft + left + 1;
        }

        if (node.right != null && node.right.val == node.val) {
            arrRight = arrRight + right + 1;
        }

        //判断每一次结果 找最大的
        res = Math.max(res, arrLeft + arrRight);

        return Math.max(arrLeft, arrRight);
    }
}
