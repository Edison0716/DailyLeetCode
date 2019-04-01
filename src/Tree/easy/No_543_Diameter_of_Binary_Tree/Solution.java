package Tree.easy.No_543_Diameter_of_Binary_Tree;


import Tree.TreeNode;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-03-19 17:22
 * Description: Diameter of Binary Tree
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 * */

public class Solution {
    private int tmp;

    public int diameterOfBinaryTree(TreeNode root) {
        tmp = 1;
        depth(root);
        return tmp - 1;//最大深度
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        int leftNodeDepth = depth(root.left); //根节点的左侧子树最大深度
        int rightNodeDepth = depth(root.right);//根节点右侧子树最大深度
        tmp = Math.max(tmp, leftNodeDepth + rightNodeDepth + 1); //左子树最大深度加上右子数 最大深度
        return Math.max(leftNodeDepth, rightNodeDepth) + 1;
    }
}
