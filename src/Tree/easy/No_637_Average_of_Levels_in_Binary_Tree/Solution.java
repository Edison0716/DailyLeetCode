package Tree.easy.No_637_Average_of_Levels_in_Binary_Tree;

import Tree.TreeNode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-03-08 20:38
 * Description: Average of Levels in Binary Tree
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 * Example 1:
 * Input:
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * Output: [3, 14.5, 11]
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 * Note:
 * 1、The range of node's value is in the range of 32-bit signed integer.
 */
public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        if (root == null)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            double avg = (double) sum / size;
            list.add(avg);
        }

        return list;
    }

    public List<Double> averageOfLevels1(TreeNode root) {
        List<Integer> count = new ArrayList<>();//用来计算是第几层的
        List<Double> resArray = new ArrayList<>();//最终结果

        average(root, 0, resArray, count);
        for (int i = 0; i < resArray.size(); i++) {
            resArray.set(i, resArray.get(i) / count.get(i));
        }
        return resArray;
    }

    private void average(TreeNode root, int i, List<Double> resArray, List<Integer> count) {
        if (root == null) return;
        if (i < resArray.size()) {
            resArray.set(i, resArray.get(i) + root.val);
            count.set(i, count.get(i) + 1);
        } else {
            //是否是树的顶端
            resArray.add(1.0 * root.val);
            count.add(1);
        }

        average(root.left, i + 1, resArray, count);
        average(root.right, i + 1, resArray, count);

    }
}
