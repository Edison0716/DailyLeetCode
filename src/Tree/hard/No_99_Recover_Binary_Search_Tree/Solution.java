package Tree.hard.No_99_Recover_Binary_Search_Tree;

import Tree.TreeNode;

/**
 * FileName: Solution
 * Author:   EdisonLi的Windows
 * Date:     2019/5/8 11:26
 * Description: Recover Binary Search Tree
 * Two elements of a binary search tree (BST) are swapped by mistake.
 *
 * Recover the tree without changing its structure.
 *
 * Example 1:
 *
 * Input: [1,3,null,null,2]
 *
 *    1
 *   /
 *  3
 *   \
 *    2
 *
 * Output: [3,1,null,null,2]
 *
 *    3
 *   /
 *  1
 *   \
 *    2
 * Example 2:
 *
 * Input: [3,1,4,null,null,2]
 *
 *   3
 *  / \
 * 1   4
 *    /
 *   2
 *
 * Output: [2,1,4,null,null,3]
 *
 *   2
 *  / \
 * 1   4
 *    /
 *   3
 *
 * Difficulty: Hard
 */

public class Solution {

    public TreeNode recoverTree(TreeNode root) {
        if(root == null) return null;
        handleTree(root);
        if (node1 != null){
            int tem = node1.val;
            node1.val = node2.val;
            node2.val = tem;
        }
        return root;
    }
    private TreeNode node1;
    private TreeNode node2;
    private TreeNode tem;
    //中序遍历
    private void handleTree(TreeNode root) {
        if (root == null) return;

        handleTree(root.left);

        if (tem != null){
            if (tem.val > root.val){
                if (node1 != null){
                    //找到第二个异常值
                    node2 = root;
                }else {
                    //找到第一个异常值
                    node1 = tem;
                    node2 = root;
                }
            }
        }
        tem = root;
        handleTree(root.right);
    }
}
