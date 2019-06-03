package Tree.medium.No_173_Binary_Search_Tree_Iterator;

import Tree.TreeNode;

import java.util.Stack;

/**
 * FileName: Solution
 * Author:   EdisonLi的Windows
 * Date:     2019/6/3 11:22
 * Description: 173. Binary Search Tree Iterator
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * <p>
 * Calling next() will return the next smallest number in the BST.
 * Example:
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // return 3
 * iterator.next();    // return 7
 * iterator.hasNext(); // return true
 * iterator.next();    // return 9
 * iterator.hasNext(); // return true
 * iterator.next();    // return 15
 * iterator.hasNext(); // return true
 * iterator.next();    // return 20
 * iterator.hasNext(); // return false
 * Difficulty: Medium
 */
public class Solution {
    private Stack<TreeNode> mStact = new Stack<>();

    public Solution(TreeNode root) {
        pushAllNode(root);
    }

    private void pushAllNode(TreeNode root) {
        for (; root != null; mStact.push(root), root = root.left);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode popStack = mStact.pop();
        pushAllNode(popStack.right);
        return popStack.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !mStact.isEmpty();
    }
}
