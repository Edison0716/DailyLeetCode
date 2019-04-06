package Tree.medium.No_979_Distribute_Coins_in_Binary_Tree;

import Tree.TreeNode;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-04-06 14:50
 * Description: Distribute Coins in Binary Tree
 * Difficulty: Medium
 * <p>
 * Given the root of a binary tree with N nodes, each node in the tree has node.val coins, and there are N coins total.
 * <p>
 * In one move, we may choose two adjacent nodes and move one coin from one node to another.  (The move may be from parent to child, or from child to parent.)
 * <p>
 * Return the number of moves required to make every node have exactly one coin.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: [3,0,0]
 * Output: 2
 * Explanation: From the root of the tree, we move one coin to its left child, and one coin to its right child.
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: [0,3,0]
 * Output: 3
 * Explanation: From the left child of the root, we move two coins to the root [taking two moves].  Then, we move one coin from the root of the tree to the right child.
 * Example 3:
 * <p>
 * <p>
 * <p>
 * Input: [1,0,2]
 * Output: 2
 * Example 4:
 * <p>
 * <p>
 * <p>
 * Input: [1,0,0,null,3]
 * Output: 4
 * <p>
 * <p>
 * Note:
 * <p>
 * 1<= N <= 100
 * 0 <= node.val <= N
 */

public class Solution {
    int[] resTimes = new int[1];

    public int distributeCoins(TreeNode root) {
        //解题思路就是 从叶子节点开始递归 看看为0则要运输一个  大于1 则需要运输 N减1次
        tranCoin(root, resTimes);
        return resTimes[0];
    }

    private int tranCoin(TreeNode root, int[] temTimes) {
        if (root == null) return 0;
        int left = tranCoin(root.left, temTimes);
        int right = tranCoin(root.right, temTimes);
        temTimes[0] += Math.abs(left) + Math.abs(right);//绝对值相加即可
        return left + right + root.val - 1; //计算需要运输多少个还要加上父节点自身的val 然后继续遍历 从叶子节点 开始往回返
    }
}
