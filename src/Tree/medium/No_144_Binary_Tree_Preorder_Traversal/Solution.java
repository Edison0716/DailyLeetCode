package Tree.medium.No_144_Binary_Tree_Preorder_Traversal;

import Tree.TreeNode;

import java.util.*;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-04-16 14:14
 * Description: Maximum Binary Tree
 * Difficulty: Medium
 * Given a binary tree, return the preorder traversal of its nodes' values.
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
 * Output: [1,2,3]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class Solution {
    //递归
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> node = new ArrayList<>();
        if (root == null) return node;
        handleNode(root,node);
        return node;
    }

    private void handleNode(TreeNode root,ArrayList<Integer> node) {
        if (root == null)return;
        node.add(root.val);
        handleNode(root.left,node);
        handleNode(root.right,node);
    }

    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> resArray = new LinkedList<>();
        Stack<TreeNode> myQueue = new Stack<>();
        while (root != null){
            resArray.add(root.val);
            if (root.right != null)
                myQueue.push(root.right);
            //先遍历左子树  左子树为空  而且 栈里 存有右子数 则依次pop
            root = root.left;
            if (root == null && !myQueue.isEmpty())
                root = myQueue.pop();
        }

        return resArray;
    }


}
