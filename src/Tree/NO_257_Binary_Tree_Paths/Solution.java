package Tree.NO_257_Binary_Tree_Paths;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-03-21 17:23
 * Description: Binary Tree Paths
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null) handle(root, "", result);
        return result;
    }

    private void handle(TreeNode root, String s, List<String> result) {
        if (root.left == null && root.right == null) result.add(s + root.val);
        if (root.left != null) handle(root.left, s + root.val + "->", result);
        if (root.right != null) handle(root.right,  s + root.val + "->", result);
    }

}
