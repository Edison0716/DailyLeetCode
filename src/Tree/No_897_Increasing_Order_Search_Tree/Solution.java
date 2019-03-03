package Tree.No_897_Increasing_Order_Search_Tree;


import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-03-02 11:12
 * Description:  Increasing Order Search Tree
 *
 * Given a tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.
 *
 * Example 1:
 * Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]
 *
 *        5
 *       / \
 *     3    6
 *    / \    \
 *   2   4    8
 *  /        / \
 * 1        7   9
 *
 * Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 *             \
 *              7
 *               \
 *                8
 *                 \
 *                  9
 * Note:
 *
 * The number of nodes in the given tree will be between 1 and 100.
 * Each node will have a unique integer value from 0 to 1000.
 */

public class Solution {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        inorder(root, vals);
        TreeNode node = new TreeNode(0), cur = node;
        for (int val : vals) {
            cur.right = new TreeNode(val);
            cur = cur.right;
        }
        return node.right;
    }

    private void inorder(TreeNode root, List<Integer> vals) {
        if (root == null) return;
        //递归 一直找到左子树最深的哪一个 往回返
        inorder(root.left, vals);
        //存入数组
        vals.add(root.val);
        //递归找右子数
        inorder(root.right, vals);
    }
}
