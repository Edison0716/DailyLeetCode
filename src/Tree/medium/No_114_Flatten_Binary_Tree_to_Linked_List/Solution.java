package Tree.medium.No_114_Flatten_Binary_Tree_to_Linked_List;

import Tree.TreeNode;

/**
 * FileName: Solution
 * Author:   EdisonLi的Windows
 * Date:     2019/4/28 12:28
 * Description:
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example, given the following tree:
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * The flattened tree should look like:
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 * Difficulty: Medium
 */
public class Solution {
    private TreeNode preNode;
    public void flatten(TreeNode root) {
        handleArray(root);
    }

    private void handleArray(TreeNode root) {
        if (root == null) return;
        handleArray(root.right);
        handleArray(root.left);
        root.right = preNode;
        root.left = null;
        preNode = root;
    }
}
