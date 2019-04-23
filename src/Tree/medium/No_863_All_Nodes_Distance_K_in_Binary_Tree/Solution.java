package Tree.medium.No_863_All_Nodes_Distance_K_in_Binary_Tree;

import Tree.TreeNode;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * FileName: Solution
 * Author:   EdisonLi的Windows
 * Date:     2019/4/23 16:56
 * Description:
 * <p>
 * We are given a binary tree (with root node root), a target node, and an integer value K.
 * <p>
 * Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * <p>
 * Output: [7,4,1]
 * <p>
 * Explanation:
 * The nodes that are a distance 2 from the target node (with value 5)
 * have values 7, 4, and 1.
 * <p>
 * <p>
 * <p>
 * Note that the inputs "root" and "target" are actually TreeNodes.
 * The descriptions of the inputs above are just serializations of these objects.
 * <p>
 * <p>
 * Note:
 * <p>
 * The given tree is non-empty.
 * Each node in the tree has unique values 0 <= node.val <= 500.
 * The target node is a node in the tree.
 * 0 <= K <= 1000.
 * <p>
 * Difficulty: Medium
 */
public class Solution {
    List<Integer> resArray = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        handleDistanceK(root, target, K);
        return resArray;
    }

    private void handleDistanceK(TreeNode root, TreeNode target, int k) {
        if (root == null) return;

        //todo 往右侧找


        //往下找
        if (root == target)
            findResult(root, k, 0);

        handleDistanceK(root.left, target, k);
        handleDistanceK(root.right, target, k);
    }


    //往下找
    private void findResult(TreeNode root, int k, int depth) {
        if (root == null) return;
        if (depth == k)
            resArray.add(root.val);
        findResult(root.left, k, depth + 1);
        findResult(root.right, k, depth + 1);
    }
}
