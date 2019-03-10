package Tree.No_993_Cousins_in_Binary_Tree;

import Tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-03-10 21:20
 * Description: Cousins in Binary Tree
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 * <p>
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 * <p>
 * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
 * <p>
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,2,3,4], x = 4, y = 3
 * Output: false
 * Example 2:
 * <p>
 * <p>
 * Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
 * Output: true
 */

public class Solution {
    Map<Integer, Integer> depth; //深度
    Map<Integer, TreeNode> parent;//保存父亲节点

    public boolean isCousins(TreeNode root, int x, int y) {
        depth = new HashMap<>();
        parent = new HashMap<>();

        dfs(root, null);

        return (depth.get(x) == depth.get(y) && parent.get(x) != parent.get(y)); //判断条件
    }

    private void dfs(TreeNode root, TreeNode par) {
        if (root != null) {
            depth.put(root.val, par != null ? depth.get(par.val) + 1 : 0); //深度+1 为空则是根节点
            parent.put(root.val, par);//保存每一个字数的父亲
            dfs(root.left, root);
            dfs(root.right, root);
        }
    }
}
