package Tree.No_897_Increasing_Order_Search_Tree;


import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-03-02 11:12
 * Description:  Increasing Order Search Tree
 */

public class Solution {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        inorder(root, vals);
        TreeNode node = new TreeNode(0), cur = node;
        for (int val : vals) {
            cur.right = new TreeNode(val);
            cur = cur.right;
        }
        return node.right;
    }

    private void inorder(TreeNode root, List<Integer> vals) {
        if (root == null) return;
        //递归 一直找到左子树最深的哪一个 往回返
        inorder(root.left, vals);
        //存入数组
        vals.add(root.val);
        //递归找右子数
        inorder(root.right, vals);
    }
}
