package Tree.medium.No_951_Flip_Equivalent_Binary_Trees;

import Tree.TreeNode;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-04-07 19:27
 * Description: Flip Equivalent Binary Trees
 * Difficulty: Medium
 * <p>
 * For a binary tree T, we can define a flip operation as follows: choose any node, and swap the left and right child subtrees.
 * <p>
 * A binary tree X is flip equivalent to a binary tree Y if and only if we can make X equal to Y after some number of flip operations.
 * <p>
 * Write a function that determines whether two binary trees are flip equivalent.  The trees are given by root nodes root1 and root2.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root1 = [1,2,3,4,5,6,null,null,null,7,8], root2 = [1,3,2,null,6,4,5,null,null,null,null,8,7]
 * Output: true
 * Explanation: We flipped at nodes with values 1, 3, and 5.
 * Flipped Trees Diagram
 * <p>
 * <p>
 * Note:
 * <p>
 * Each tree will have at most 100 nodes.
 * Each value in each tree will be a unique integer in the range [0, 99].
 */

public class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        //前戏 判断 递归终止
        if (root1 == root2) return true;

        if (root1 == null || root2 == null || root1.val != root2.val) return false;

        //满足一个条件的&&即返回true 要么 左 = 左 && 右 = 右 || 左 = 右 && 右=左
        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) || flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }
}
