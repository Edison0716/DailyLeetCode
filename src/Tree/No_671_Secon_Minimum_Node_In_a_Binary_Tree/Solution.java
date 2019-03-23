package Tree.No_671_Secon_Minimum_Node_In_a_Binary_Tree;


import Tree.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-03-23 23:16
 * Description: Second Minimum Node In a Binary Tree
 * Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes.
 *
 * Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
 *
 * If no such second minimum value exists, output -1 instead.
 *
 * Example 1:
 * Input:
 *     2
 *    / \
 *   2   5
 *      / \
 *     5   7
 *
 * Output: 5
 * Explanation: The smallest value is 2, the second smallest value is 5.
 * Example 2:
 * Input:
 *     2
 *    / \
 *   2   2
 *
 * Output: -1
 * Explanation: The smallest value is 2, but there isn't any second smallest value.
 */

public class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        Set<Integer> set = new HashSet<>();
        handleOrder(root, set);
        if (set.size() < 2) return -1;

        int point = 0;

        //遍历数组找第二个
        for (int num : set) {
            if (point == 1)
                return num;
            else
                point++;
        }

        return -1;
    }


    //将Tree遍历 存入集合中 set 保证数无重复value
    private void handleOrder(TreeNode header, Set<Integer> set) {
        if (header == null) return;
        set.add(header.val);
        handleOrder(header.left, set);
        handleOrder(header.right, set);
    }
}
