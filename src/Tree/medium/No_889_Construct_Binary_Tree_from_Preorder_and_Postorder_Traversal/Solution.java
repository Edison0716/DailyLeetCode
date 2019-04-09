package Tree.medium.No_889_Construct_Binary_Tree_from_Preorder_and_Postorder_Traversal;


import Tree.TreeNode;

import java.util.Arrays;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-04-09 12:41
 * Description: Construct Binary Tree from Preorder and Postorder Traversal
 * Difficulty: Medium
 *
 * Return any binary tree that matches the given preorder and postorder traversals.
 *
 * Values in the traversals pre and post are distinct positive integers.
 *
 *
 *
 * Example 1:
 *
 * Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
 * Output: [1,2,3,4,5,6,7]
 *
 *
 * Note:
 *
 * 1 <= pre.length == post.length <= 30
 * pre[] and post[] are both permutations of 1, 2, ..., pre.length.
 * It is guaranteed an answer exists. If there exists multiple answers, you can return any of them.
 *
 */
public class Solution {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int size = pre.length;
        if (size == 0) return null;
        TreeNode treeNode = new TreeNode(pre[0]);
        if (size == 1)
            return treeNode;

        //开始找区间 也就是 找生成树的 左右子树
        int L = 0;
        for (int i = 0; i < size; ++i)
            if (post[i] == pre[1])
                L = i+1;

        treeNode.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, L+1),
                Arrays.copyOfRange(post, 0, L));
        treeNode.right = constructFromPrePost(Arrays.copyOfRange(pre, L+1,size),
                Arrays.copyOfRange(post, L, size-1));
        return treeNode;
    }
}
