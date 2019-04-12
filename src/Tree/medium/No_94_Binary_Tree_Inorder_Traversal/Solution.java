package Tree.medium.No_94_Binary_Tree_Inorder_Traversal;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-04-12 13:22
 * Description: Maximum Binary Tree
 * Difficulty: Medium
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,3,2]
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> resArray = new ArrayList<>();

        handleList(root,resArray);

        return resArray;
    }

    private void handleList(TreeNode root, List<Integer> resArray) {
        if (root != null) {
            if (root.left != null) {
                handleList(root.left, resArray);
            }

            resArray.add(root.val);

            if (root.right != null) {
                handleList(root.right, resArray);
            }
        }
    }
}
