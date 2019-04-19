package Tree.medium.No_102_Binary_Tree_Level_Order_Traversal;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * FileName: Solution
 * Author:   EdisonLi的Windows
 * Date:     2019/4/19 12:09
 * Description:
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * Difficulty: Medium
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resArray = new ArrayList<>();
        handleLevelOrder(root,resArray,0);
        return resArray;
    }

    private void handleLevelOrder(TreeNode root, List<List<Integer>> resArray,int depth) {
        if (root == null) return;
        if (depth >= resArray.size())
            resArray.add(new ArrayList<Integer>());

        resArray.get(depth).add(root.val);

        if (root.left != null)
            handleLevelOrder(root.left,resArray,depth + 1);

        if (root.right != null)
            handleLevelOrder(root.right,resArray,depth + 1);
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> resArray = new ArrayList<>();
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        if (root == null) return resArray;
        treeNodeQueue.offer(root);
        while (!treeNodeQueue.isEmpty()){
            int temQueueSize = treeNodeQueue.size();
            ArrayList<Integer> temArray = new ArrayList<>();
            //与No107 方法类似
            for(int i = 0;i<temQueueSize;i++){
                if (treeNodeQueue.peek().left!=null)
                    treeNodeQueue.offer(treeNodeQueue.peek().left);
                if (treeNodeQueue.peek().right!=null)
                    treeNodeQueue.offer(treeNodeQueue.peek().right);
                temArray.add(treeNodeQueue.poll().val);
            }
            resArray.add(temArray);
        }
        return resArray;
    }
}
