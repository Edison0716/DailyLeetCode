package Tree.easy.No_1022_Sum_of_Root_To_Leaf_Binary_Numbers;

import Tree.TreeNode;

/**
 * FileName: Solution
 * Author:   EdisonLi的Windows
 * Date:     2019/5/21 11:28
 * Description:
 * Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary number starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
 * <p>
 * For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
 * <p>
 * Return the sum of these numbers.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,0,1,0,1,0,1]
 * Output: 22
 * Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 * <p>
 * <p>
 * Note:
 * The number of nodes in the tree is between 1 and 1000.
 * node.val is 0 or 1.
 * The answer will not exceed 2^31 - 1.
 * Difficulty: Easy
 */
public class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return handle(root, 0);
    }
    private int handle(TreeNode root, int result) {
        if (root == null) return 0;
        // 每左移一位 整体乘以2 + root.val 得的是二进制转十进制的数
        result = result * 2 + root.val;
        return root.left == root.right ? result : handle(root.left, result) + handle(root.right, result);
    }
}
