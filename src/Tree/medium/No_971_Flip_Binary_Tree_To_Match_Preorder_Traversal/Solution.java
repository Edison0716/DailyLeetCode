package Tree.medium.No_971_Flip_Binary_Tree_To_Match_Preorder_Traversal;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * FileName: Solution
 * Author:   EdisonLi的Windows
 * Date:     2019/4/26 12:09
 * Description: 971 Flip Binary Tree To Match Preorder Traversal
 *
 * Given a binary tree with N nodes, each node has a different value from {1, ..., N}.
 *
 * A node in this binary tree can be flipped by swapping the left child and the right child of that node.
 *
 * Consider the sequence of N values reported by a preorder traversal starting from the root.  Call such a sequence of N values the voyage of the tree.
 *
 * (Recall that a preorder traversal of a node means we report the current node's value, then preorder-traverse the left child, then preorder-traverse the right child.)
 *
 * Our goal is to flip the least number of nodes in the tree so that the voyage of the tree matches the voyage we are given.
 *
 * If we can do so, then return a list of the values of all nodes flipped.  You may return the answer in any order.
 *
 * If we cannot do so, then return the list [-1].
 *
 *
 *
 * Example 1:
 *
 *           1            2
 *          /              \
 *         2                1
 *
 * Input: root = [1,2], voyage = [2,1]
 * Output: [-1]
 * Example 2:
 *
 *        1               1
 *      /   \           /   \
 *     2     3         3     2
 *
 * Input: root = [1,2,3], voyage = [1,3,2]
 * Output: [1]
 * Example 3:
 *
 *          1               1
 *        /   \           /   \
 *       2     3         2     3
 *
 * Input: root = [1,2,3], voyage = [1,2,3]
 * Output: []
 *
 *
 *
 * Note:
 *
 * 1 <= N <= 100
 *
 * Difficulty: Medium
 */
public class Solution {
    int index = 0;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> resArray = new ArrayList<>();
        if (dfs(root, voyage, resArray)) {
            return resArray;
        } else {
            return Collections.singletonList(-1);
        }
    }

    //voyage 是先序遍历
    private boolean dfs(TreeNode root, int[] voyage, List<Integer> resArray) {
        if (root == null) return true;
        if (root.val != voyage[index++]) return false; //翻转只要不相等则递归终止 返回false
        if (root.left != null && root.left.val == voyage[index]) {
            //左子树不为空 而且等于先序遍历的顺序 则继续遍历左右子树
            return dfs(root.left, voyage, resArray) && dfs(root.right, voyage, resArray);
        } else if (root.right != null && root.right.val == voyage[index]) {
            //左子树不为空 但是右子树等于了本应该是左子树的数 所以说明先序遍历中的这一二叉树有逆序
            if (root.left != null)
                resArray.add(root.val);
            return dfs(root.right, voyage, resArray) && dfs(root.left, voyage, resArray);
        }
        return root.left == null && root.right == null;
    }
}
