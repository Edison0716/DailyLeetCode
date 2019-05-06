package Tree.medium.No_105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;

import Tree.TreeNode;

/**
 * FileName: Solution
 * Author:   EdisonLi的Windows
 * Date:     2019/4/29 15:01
 * Description:
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLength = preorder.length;
        int inLength = inorder.length;
        return buildTree(preorder, 0, preLength - 1, inorder, 0, inLength - 1);
    }

    private TreeNode buildTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (inStart > inEnd || preStart > preEnd)
            return null;

        int rootVal = pre[preStart]; //前序遍历第一个就是根
        int rootIndex = 0;

        //在中序遍历中找目标
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }

        int len = rootIndex - inStart; //获取左子树长度

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(pre, preStart + 1, preStart + len, in, inStart, rootIndex - 1);
        root.right = buildTree(pre, preStart + len + 1, preEnd, in, rootIndex + 1, inEnd);

        return root;
    }
}
