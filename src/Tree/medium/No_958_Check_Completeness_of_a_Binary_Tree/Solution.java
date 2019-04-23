package Tree.medium.No_958_Check_Completeness_of_a_Binary_Tree;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * FileName: Solution
 * Author:   EdisonLi的Windows
 * Date:     2019/4/23 9:49
 * Description:
 *
 * Given a binary tree, determine if it is a complete binary tree.
 *
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: [1,2,3,4,5,6]
 * Output: true
 * Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}), and all nodes in the last level ({4, 5, 6}) are as far left as possible.
 * Example 2:
 *
 *
 *
 * Input: [1,2,3,4,5,null,7]
 * Output: false
 * Explanation: The node with value 7 isn't as far left as possible.
 *
 * Note:
 *
 * The tree will have between 1 and 100 nodes.
 *
 * Difficulty: Medium
 */
public class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);

        //层序遍历 直到有null就停下来 要是找到了null 如果是完全二叉树 说明之后都应该是null
        while (treeNodeQueue.peek() != null){
            TreeNode node = treeNodeQueue.poll();
            treeNodeQueue.offer(node.left);
            treeNodeQueue.offer(node.right);
        }

        //验证
        while (!treeNodeQueue.isEmpty() && treeNodeQueue.peek() == null){
            treeNodeQueue.poll();
        }

        return treeNodeQueue.isEmpty();
    }
}
