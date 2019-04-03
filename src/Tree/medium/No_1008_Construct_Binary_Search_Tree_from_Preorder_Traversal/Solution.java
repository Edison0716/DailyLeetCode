package Tree.medium.No_1008_Construct_Binary_Search_Tree_from_Preorder_Traversal;

import Tree.TreeNode;

import java.util.Stack;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-04-03 09:18
 * Description: Construct Binary Search Tree from Preorder Traversal
 * Difficulty: Medium
 * <p>
 * Return the root node of a binary search tree that matches the given preorder traversal.
 * <p>
 * (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= preorder.length <= 100
 * The values of preorder are distinct.
 */

public class Solution {
    private int i = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return handleNode(preorder, Integer.MAX_VALUE);
    }

    private TreeNode handleNode(int[] preorder, int bound) {
        if (i == preorder.length || preorder[i] > bound) return null;
        TreeNode node = new TreeNode(preorder[i++]);
        node.left = handleNode(preorder, node.val);
        node.right = handleNode(preorder, bound);
        return node;
    }



    public TreeNode bstFromPreorder1(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = new TreeNode(preorder[i]);
            if (preorder[i] < stack.peek().val) {
                stack.peek().left = node;
            } else {
                TreeNode parent = stack.peek();
                while (!stack.isEmpty() && preorder[i] > stack.peek().val) {
                    parent = stack.pop();
                }
                parent.right = node;
            }
            stack.push(node);
        }
        return root;
    }
}
