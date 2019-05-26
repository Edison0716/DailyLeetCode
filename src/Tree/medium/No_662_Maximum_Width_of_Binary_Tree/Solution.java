package Tree.medium.No_662_Maximum_Width_of_Binary_Tree;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-05-26 20:32
 * Description: Maximum Width of Binary Tree
 * Difficulty: Medium
 * Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.
 *
 * The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.
 *
 * Example 1:
 *
 * Input:
 *
 *            1
 *          /   \
 *         3     2
 *        / \     \
 *       5   3     9
 *
 * Output: 4
 * Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
 * Example 2:
 *
 * Input:
 *
 *           1
 *          /
 *         3
 *        / \
 *       5   3
 *
 * Output: 2
 * Explanation: The maximum width existing in the third level with the length 2 (5,3).
 * Example 3:
 *
 * Input:
 *
 *           1
 *          / \
 *         3   2
 *        /
 *       5
 *
 * Output: 2
 * Explanation: The maximum width existing in the second level with the length 2 (3,2).
 * Example 4:
 *
 * Input:
 *
 *           1
 *          / \
 *         3   2
 *        /     \
 *       5       9
 *      /         \
 *     6           7
 * Output: 8
 * Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).
 *
 *
 * Note: Answer will in the range of 32-bit signed integer.
 */

public class Solution {
    private ArrayList<Integer> start = new ArrayList<>();
    private ArrayList<Integer> end = new ArrayList<>();

    //根 * 2 = 左子树  根 * 2 + 1 = 右子数
    public int widthOfBinaryTree(TreeNode root) {
        return handleTreeNode(root, 0, 1, start, end);
    }

    private int handleTreeNode(TreeNode root, int depth, int index, ArrayList<Integer> start, ArrayList<Integer> end) {
        if (root == null) return 0;

        if (start.size() == depth) {
            start.add(index);
            end.add(index);
        }

        end.set(depth, index);
        //求最大宽度
        int curNode = end.get(depth) - start.get(depth) + 1;
        //重点来了
        int left = handleTreeNode(root.left, depth + 1, index * 2, start, end);
        int right = handleTreeNode(root.right, depth + 1, index * 2 + 1, start, end);

        return Math.max(Math.max(left, right), curNode);
    }
}
