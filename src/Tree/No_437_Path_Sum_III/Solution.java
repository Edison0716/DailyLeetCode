package Tree.No_437_Path_Sum_III;


import Tree.TreeNode;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-03-25 22:17
 * Description: Path Sum III
 *You are given a binary tree in which each node contains an integer value.
 *
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * Example:
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 */
public class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int pathSumFrom(TreeNode node, int sum) {
        if (node == null) return 0;
        return (node.val == sum ? 1 : 0) + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
    }


    public int pathSum2(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumFrom2(root, sum) + pathSum2(root.left, sum) + pathSum2(root.right, sum);
    }

    private int pathSumFrom2(TreeNode node, int sum) {
        int res = 0;
        if (node == null)
            return res;
        if (sum == node.val)
            res++;
        res += pathSumFrom2(node.left, sum - node.val);
        res += pathSumFrom2(node.right, sum - node.val);
        return res;
    }
}
