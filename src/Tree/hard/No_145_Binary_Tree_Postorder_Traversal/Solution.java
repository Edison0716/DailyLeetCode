package Tree.hard.No_145_Binary_Tree_Postorder_Traversal;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * FileName: Solution
 * Author:   EdisonLi的Windows
 * Date:     2019/5/25 21:17
 * Description: Binary Tree Postorder Traversal
 * Given a binary tree, return the postorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [3,2,1]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 *
 * Difficulty: Hard
 */
public class Solution {
    private List<Integer> resList = new ArrayList<>();
    private LinkedList<Integer> resList1 = new LinkedList<>();

    //迭代
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return resList;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode currNode = null;

        while (!stack.isEmpty()){
            currNode = stack.pop();
            resList1.addFirst(currNode.val);
            if (currNode.left != null) stack.push(currNode.left);
            if (currNode.right != null) stack.push(currNode.right);
        }
        return resList;
    }


    //递归方式
    public List<Integer> postorderTraversal1(TreeNode root) {
        handleNode(root);
        return resList;
    }

    private void handleNode(TreeNode root) {
        if (root == null) {
            return;
        }

        handleNode(root.left);
        handleNode(root.right);
        resList.add(root.val);
    }



}
