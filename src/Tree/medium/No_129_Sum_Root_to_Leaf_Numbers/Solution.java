package Tree.medium.No_129_Sum_Root_to_Leaf_Numbers;

import Tree.TreeNode;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-04-27 22:18
 * Description: Sum Root to Leaf Numbers
 * Difficulty: Medium
 *
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 *
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * Find the total sum of all root-to-leaf numbers.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input: [1,2,3]
 *     1
 *    / \
 *   2   3
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 * Example 2:
 *
 * Input: [4,9,0,5,1]
 *      4
 *     / \
 *    9   0
 *   / \
 *  5   1
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 *
 */

public class Solution {
    public int sumNumbers(TreeNode root) {
        return handleDfs(root, 0);
    }

    //深度递归即可 没次递归带上倍数即可 比较简单
    private int handleDfs(TreeNode root, int tem) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return tem * 10 + root.val;
        return handleDfs(root.left,tem * 10 + root.val) + handleDfs(root.right,tem * 10 + root.val);
    }
}
