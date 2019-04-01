package Tree.easy.No_653_Two_Sum_IV_Input_is_a_BST;


import Tree.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-03-11 21:14
 * Description: Two Sum IV - Input is a BST
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.
 *
 * Example 1:
 *
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * Output: True
 *
 *
 * Example 2:
 *
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 28
 *
 * Output: False
 */


public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> myTemSet = new HashSet<>();

        return find(root, myTemSet, k);

    }

    private boolean find(TreeNode root, Set<Integer> set, int k) {
        if (root == null) return false;

        if (set.contains(k - root.val)) {
            return true;
        }

        set.add(root.val);

        return find(root.left, set, k) || find(root.right, set, k);
    }

    public boolean findTarget1(TreeNode root, int k) {
        Set<Integer> myTemSet = new HashSet<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            //判断队列是不是空
            if (queue.peek() != null) {//获取队列头元素
                TreeNode treeNode = queue.remove();
                if (myTemSet.contains(k - treeNode.val)){
                    return true;
                }
                myTemSet.add(treeNode.val);
                queue.add(treeNode.left);
                queue.add(treeNode.right);
            }else {
                queue.remove();//不是空 则remove
            }
        }

        return false;
    }
}
