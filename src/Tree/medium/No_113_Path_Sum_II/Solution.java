package Tree.medium.No_113_Path_Sum_II;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * FileName: Solution
 * Author:   EdisonLi的Windows
 * Date:     2019/4/30 13:30
 * Description:
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * Return:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * Difficulty: Medium
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> resArray = new LinkedList<>();
        List<Integer> temArray = new LinkedList<>();
        handlePath(root, resArray, temArray, sum);
        return resArray;
    }

    private void handlePath(TreeNode root, List<List<Integer>> resArray, List<Integer> temArray, int sum) {
        if (root == null) return;
        temArray.add(root.val);
        //一条路径判断符合条件的终止条件
        if (root.left == null && root.right == null && sum == root.val) {
            resArray.add(new LinkedList<>(temArray));
            //移除最后一个
            temArray.remove(temArray.size() - 1);
            return;
        } else {
            handlePath(root.left, resArray, temArray, sum - root.val);
            handlePath(root.right, resArray, temArray, sum - root.val);
        }
        temArray.remove(temArray.size() - 1);
    }
}
