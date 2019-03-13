package Tree.No_538_Convert_BST_to_Greater_Tree;


import Tree.TreeNode;

import java.util.Stack;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-03-13 10:27
 * Description: Convert BST to Greater Tree
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
 *
 * Example:
 *
 * Input: The root of a Binary Search Tree like this:
 *               5
 *             /   \
 *            2     13
 *
 * Output: The root of a Greater Tree like this:
 *              18
 *             /   \
 *           20     13
 */

public class Solution {
    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);//右子数总比根节点大
            sum += root.val;
            root.val = sum;//右子数 累加完成
            convertBST(root.left); //之后左子树
        }
        return root;
    }

    public TreeNode convertBST1(TreeNode root) {
        int sum = 0;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || node != null) {
            //先将从根节点的所有的右子树推入栈
            while (node != null) {
                stack.add(node);
                node = node.right;
            }
            //先将右数开始累加
            node = stack.pop();
            sum += node.val;
            node.val = sum;
            //左子树再来一遍
            node = node.left;
        }

        return root;
    }

}
