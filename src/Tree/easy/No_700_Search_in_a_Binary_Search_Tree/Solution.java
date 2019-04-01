package Tree.easy.No_700_Search_in_a_Binary_Search_Tree;

import Tree.TreeNode;

/**
 * FileName: Solution
 * Author:   mac
 * Date:     2019-02-26 10:12
 * Description: Search in a Binary Search Tree
 * <p>
 * Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's value equals the given value. Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.
 * <p>
 * For example,
 * <p>
 * Given the tree:
 * 4
 * / \
 * 2   7
 * / \
 * 1   3
 * <p>
 * And the value to search: 2
 * You should return this subtree:
 * <p>
 * 2
 * / \
 * 1   3
 * In the example above, if we want to search the value 5, since there is no node with value 5, we should return NULL.
 * <p>
 * Note that an empty tree is represented by NULL, therefore you would see the expected output (serialized tree format) as [], not null.
 */
public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode currentRoot = root;
        //大数放右边 小数放左边
        while (currentRoot != null) {
            if (currentRoot.val == val) {
                return currentRoot;
            } else if (currentRoot.val > val) {
                currentRoot = currentRoot.left;
            } else {
                currentRoot = currentRoot.right;
            }
        }
        return null;
    }
}
