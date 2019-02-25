package Tree.No_617_Merge_Two_Binary_Trees;

import Tree.TreeNode;

import java.util.Stack;

/**
 * FileName: Solution
 * Author:   mac
 * Date:     2019-02-25 11:01
 * Description: Merge Two Binary Trees
 * <p>
 * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
 * <p>
 * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * Tree 1                     Tree 2
 * 1                         2
 * / \                       / \
 * 3   2                     1   3
 * /                           \   \
 * 5                             4   7
 * Output:
 * Merged tree:
 * 3
 * / \
 * 4   5
 * / \   \
 * 5   4   7
 * <p>
 * Note: The merging process must start from the root nodes of both trees.
 */
public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }


    public TreeNode mergeTrees1(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{t1, t2});
        while (!stack.isEmpty()) {
            TreeNode[] popTreeNode = stack.pop();
            if (popTreeNode[0] == null || popTreeNode[1] == null) {
                continue;
            }

            popTreeNode[0].val += popTreeNode[1].val;

            if (popTreeNode[0].left == null){
                popTreeNode[0].left = popTreeNode[1].left;
            }else {
                stack.push(new TreeNode[]{popTreeNode[0].left,popTreeNode[1].left});
            }

            if (popTreeNode[0].right == null){
                popTreeNode[0].right = popTreeNode[1].right;
            }else {
                stack.push(new TreeNode[]{popTreeNode[0].right,popTreeNode[1].right});
            }
        }
        return t1;
    }
}
