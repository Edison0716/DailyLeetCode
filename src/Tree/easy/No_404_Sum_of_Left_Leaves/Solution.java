package Tree.easy.No_404_Sum_of_Left_Leaves;

import Tree.TreeNode;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-03-17 21:58
 * Description: Sum of Left Leaves
 * Find the sum of all left leaves in a given binary tree.
 *  *
 *  * Example:
 *  *
 *  *     3
 *  *    / \
 *  *   9  20
 *  *     /  \
 *  *    15   7
 *  *
 *  * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */

public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) sum += root.left.val; //说明从根节点的左子树递归完成
            else {
                sum += sumOfLeftLeaves(root.left);//否则继续递归
            }
        }
        sum += sumOfLeftLeaves(root.right);//根节点的右子数开始递归
        return sum;
    }
}
