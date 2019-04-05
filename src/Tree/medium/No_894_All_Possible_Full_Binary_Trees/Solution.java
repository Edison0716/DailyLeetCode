package Tree.medium.No_894_All_Possible_Full_Binary_Trees;


import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-04-05 14:27
 * Description: All Possible Full Binary Trees
 * Difficulty: Medium
 * <p>
 * A full binary tree is a binary tree where each node has exactly 0 or 2 children.
 * <p>
 * Return a list of all possible full binary trees with N nodes.  Each element of the answer is the root node of one possible tree.
 * <p>
 * Each node of each tree in the answer must have node.val = 0.
 * <p>
 * You may return the final list of trees in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 7
 * Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 * Explanation:
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 20
 */

public class Solution {
    public List<TreeNode> allPossibleFBT(int N, String tag) {
        System.out.println(tag + N);
        List<TreeNode> res = new ArrayList<>();
        if (N == 1) {
            TreeNode treeNode = new TreeNode(0);
            res.add(treeNode);
            return res;
        }
        //满二叉树肯定N为奇数
        for (int i = 1; i < N; i += 2) {
            List<TreeNode> left = allPossibleFBT(i, "left");
            List<TreeNode> right = allPossibleFBT(N - i - 1, "right"); //减 1 是减的 父节点
            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode treeNode = new TreeNode(0);
                    treeNode.left = leftNode;
                    treeNode.right = rightNode;
                    res.add(treeNode);
                }
            }
        }
        return res;
    }

    public List<TreeNode> allPossibleFBT1(int N) {
        ArrayList<TreeNode> resNodeList = new ArrayList<>();
        if (N % 2 == 0 || N <= 0) return resNodeList;

        if (N == 1) {
            TreeNode treeNode = new TreeNode(0);
            resNodeList.add(treeNode);
            return resNodeList;
        }

        for (int i = 1; i < N; i += 2) {
            List<TreeNode> nodeLeft = allPossibleFBT1(i);
            List<TreeNode> nodeRight = allPossibleFBT1(N - i - 1);
            for (TreeNode leftNode : nodeLeft) {
                for (TreeNode rightNode : nodeRight) {
                    TreeNode treeNode = new TreeNode(0);
                    treeNode.left = leftNode;
                    treeNode.right = rightNode;
                    resNodeList.add(treeNode);
                }
            }
        }

        return resNodeList;
    }
}
