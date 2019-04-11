package Tree.medium.No_515_Find_Largest_Value_in_Each_Tree_Row;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-04-11 12:32
 * Description: Maximum Binary Tree
 * Difficulty: Medium
 * You need to find the largest value in each row of a binary tree.
 *
 * Example:
 * Input:
 *
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 *
 * Output: [1, 3, 9]
 */
public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        res.clear();
        handleMessage(root, res, 0);
        return res;
    }

    private void handleMessage(TreeNode root, List<Integer> res, int index) {
        if (root == null) return;

        if (index == res.size()) {
            //添加新数据
            res.add(root.val);
        } else {
            //比对数据 看那个大
            res.set(index,Math.max(res.get(index),root.val));
        }
        //递归子树
        handleMessage(root.left, res, index + 1);
        handleMessage(root.right, res, index + 1);
    }

    //bfs
    public List<Integer> largestValues1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        queue.add(root);

        int queueSize;
        if (root == null){
            queueSize = 0;
        }else {
            queueSize = 1;
        }

        while (queueSize > 0){
            int largest = Integer.MIN_VALUE;
            for (int i  = 0; i < queueSize;i++){
                TreeNode treeNode = queue.poll();
                largest = Math.max(treeNode.val,largest);
                if (treeNode.left != null ) queue.add(treeNode.left);
                if (treeNode.right != null) queue.add(treeNode.right);
            }
            res.add(largest);
            queueSize = queue.size();
        }

        return res;
    }
}
