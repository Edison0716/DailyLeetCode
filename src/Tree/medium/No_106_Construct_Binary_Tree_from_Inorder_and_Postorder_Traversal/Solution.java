package Tree.medium.No_106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;

import Tree.TreeNode;

/**
 * FileName: Solution
 * Author:   EdisonLi的Windows
 * Date:     2019/5/5 15:24
 * Description: Construct Binary Tree from Inorder and Postorder Traversal
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Difficulty: Medium
 */
public class Solution {
    private int postIndex = 0; //后序遍历 最后的指就是root
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) return null;
        postIndex = postorder.length - 1;
        return helper(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int start, int end) {
        if (start > end || postIndex < 0) return null;
        TreeNode temNode = new TreeNode(postorder[postIndex--]); //每次递归的根
        int index = searchInorderArray(inorder, temNode.val, start, end);//从中序遍历中找到目标root
        temNode.right = helper(inorder, postorder,index + 1, end);//左右即为左子树和右子树
        temNode.left = helper(inorder, postorder, start, index - 1);
        return temNode;
    }

    private int searchInorderArray(int[] inorder, int target, int start, int end) {
        for (int i = start; i <= end; i++){
            if (target == inorder[i])
                return i;
        }
        return -1;
    }
}
