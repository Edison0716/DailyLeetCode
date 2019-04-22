package Tree.medium.No_623_Add_One_Row_to_Tree;

import Tree.TreeNode;

/**
 * FileName: Solution
 * Author:   EdisonLi的Windows
 * Date:     2019/4/22 12:21
 * Description:
 * Given the root of a binary tree, then value v and depth d, you need to add a row of nodes with value v at the given depth d. The root node is at depth 1.
 *
 * The adding rule is: given a positive integer depth d, for each NOT null tree nodes N in depth d-1, create two tree nodes with value v as N's left subtree root and right subtree root. And N's original left subtree should be the left subtree of the new left subtree root, its original right subtree should be the right subtree of the new right subtree root. If depth d is 1 that means there is no depth d-1 at all, then create a tree node with value v as the new root of the whole original tree, and the original tree is the new root's left subtree.
 *
 * Example 1:
 * Input:
 * A binary tree as following:
 *        4
 *      /   \
 *     2     6
 *    / \   /
 *   3   1 5
 *
 * v = 1
 *
 * d = 2
 *
 * Output:
 *        4
 *       / \
 *      1   1
 *     /     \
 *    2       6
 *   / \     /
 *  3   1   5
 *
 * Example 2:
 * Input:
 * A binary tree as following:
 *       4
 *      /
 *     2
 *    / \
 *   3   1
 *
 * v = 1
 *
 * d = 3
 *
 * Output:
 *       4
 *      /
 *     2
 *    / \
 *   1   1
 *  /     \
 * 3       1
 * Note:
 * The given d is in range [1, maximum depth of the given tree + 1].
 * The given binary tree has at least one tree node.
 *
 * Difficulty: Medium
 */
class Solution {

    //逆向思维
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        //递归终止条件
        if (d == 0 || d == 1) {
            TreeNode newNode = new TreeNode(v);
            newNode.left = d == 1 ? root : null;
            newNode.right = d == 0 ? root : null;
            return newNode;
        }


        if (root != null && d >= 2) {
            root.left = addOneRow(root.left, v, d > 2 ? d - 1 : 1);
            root.right = addOneRow(root.right, v, d > 2 ? d - 1 : 0);
        }

        return root;
    }


    //先递归到目标深度的上一个深度  然后插入元素
    public TreeNode addOneRow1(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        handleAddOneRow1(root, v, d, 1);
        return root;
    }

    private void handleAddOneRow1(TreeNode root, int v, int tarD, int curD) {
        if (root == null) return;

        if (tarD - 1 == curD) {
            TreeNode temLeftRoot = root.left;
            root.left = new TreeNode(v);
            root.left.left = temLeftRoot;


            temLeftRoot = root.right;
            root.right = new TreeNode(v);
            root.right.right = temLeftRoot;

            return;
        }

        handleAddOneRow1(root.left, v, tarD, curD + 1);
        handleAddOneRow1(root.right, v, tarD, curD + 1);
    }
}