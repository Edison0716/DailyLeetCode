package Tree.medium.No_230_Kth_Smallest_Element_in_a_BST;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * FileName: Solution
 * Author:   EdisonLi的Windows
 * Date:     2019-04-17 09:57
 * Description: Maximum Binary Tree
 * Difficulty: Medium
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * Example 1:
 *
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * Output: 3
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 */
public class Solution {
    // O(N)
    public int kthSmallest(TreeNode root, int k) {
        //中序遍历 就是从小到大排序
        ArrayList<Integer> temContainer = new ArrayList<>();
        handleNode(root,temContainer);
        return temContainer.get(k - 1);
    }

    private void handleNode(TreeNode root, ArrayList<Integer> temContainer) {
        if (root == null) return;
        if (root.left != null)
            handleNode(root.left,temContainer);
        temContainer.add(root.val);
        if (root.right != null)
            handleNode(root.right,temContainer);
    }


    // O(N)
    public int kthSmallest1(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null){
            stack.push(root);
            root = root.left;
        }

        //先遍历左在遍历右 也是按照从小到大输出
        while (k != 0){
            TreeNode treeNode = stack.pop();
            k--;
            if (k == 0)
                return treeNode.val;
            TreeNode treeRight = treeNode.right;
            while (treeRight!=null){
                stack.push(treeRight);
                treeRight = treeRight.left;
            }
        }
        return -1;
    }
}
