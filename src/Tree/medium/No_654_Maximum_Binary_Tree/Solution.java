package Tree.medium.No_654_Maximum_Binary_Tree;


import Tree.TreeNode;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-04-01 10:03
 * Description: Maximum Binary Tree
 * Difficulty: Medium
 *
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
 *
 * The root is the maximum number in the array.
 * The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 * The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 * Construct the maximum tree by the given array and output the root node of this tree.
 *
 * Example 1:
 * Input: [3,2,1,6,0,5]
 * Output: return the tree root node representing the following tree:
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 * Note:
 * The size of the given array will be in the range [1,1000].
 *
 */
public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return getMaxNum(0,nums.length - 1,nums);
    }

    private TreeNode getMaxNum(int start, int end, int[] nums) {
        if (start > end) return null;
        int max = nums[start];
        int current = start;

        //每次递归 找到最大值 在指定左右区间进行找最大的作为子树
        for (int i = start + 1; i <= end; i++){
            if (max < nums[i]){
                max = nums[i];
                current = i;
            }
        }

        TreeNode treeNode = new TreeNode(max);
        treeNode.left = getMaxNum(start,current - 1,nums); //左右子树 每次遍历 找最大 下标有所变化
        treeNode.right = getMaxNum(current + 1,end,nums);

        return treeNode;
    }
}
