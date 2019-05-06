package Tree.medium.No_222_Count_Complete_Tree_Nodes;

import Tree.TreeNode;
import java.util.Stack;

/**
 * FileName: Solution
 * Author:   EdisonLi的Windows
 * Date:     2019/5/6 17:22
 * Description: 222. Count Complete Tree Nodes
 * Given a complete binary tree, count the number of nodes.
 * Note:
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 *
 * Example:
 *
 * Input:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * Output: 6
 * Difficulty: Medium
 */
public class Solution {
    int total = 0;

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        handleNodes(root);
        return total;
    }

    private void handleNodes(TreeNode root) {
        if (root == null) return;
        total++;
        handleNodes(root.left);
        handleNodes(root.right);
    }

    public int countNodes1(TreeNode root){
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode peek = stack.pop();
            total++;
            if (peek.left != null) stack.push(peek.left);
            if (peek.right != null) stack.push(peek.right);
        }
        return total;
    }
}
