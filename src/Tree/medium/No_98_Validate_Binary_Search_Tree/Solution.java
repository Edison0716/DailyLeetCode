package Tree.medium.No_98_Validate_Binary_Search_Tree;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * FileName: Solution
 * Author:   EdisonLi的Windows
 * Date:     2019/5/6 10:45
 * Description: 98. Validate Binary Search Tree
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 *     2
 *    / \
 *   1   3
 *
 * Input: [2,1,3]
 * Output: true
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 *
 * Difficulty: Medium
 *
 */
public class Solution {
    private List<Integer> mContainer = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        //中序遍历
        inorderBST(root);
        for (int i = 1; i < mContainer.size(); i++){
            if (mContainer.get(i) <= mContainer.get(i - 1)) return false;
        }
        return true;
    }

    private void inorderBST(TreeNode root) {
        if (root == null) return;
        inorderBST(root.left);
        mContainer.add(root.val);
        inorderBST(root.right);
    }

    //想简单了
    public boolean isValidBST1(TreeNode root) {
        if (root == null) return true;
        if (root.right != null && root.val >= root.right.val)
            return false;
        if (root.left != null && root.val <= root.left.val)
            return false;
        return isValidBST1(root.left) && isValidBST1(root.right);
    }
}
