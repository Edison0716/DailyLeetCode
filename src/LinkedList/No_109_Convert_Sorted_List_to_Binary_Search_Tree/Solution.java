package LinkedList.No_109_Convert_Sorted_List_to_Binary_Search_Tree;

import LinkedList.ListNode;
import Tree.TreeNode;

/**
 * FileName: Solution
 * Author:   EdisonLi的Windows
 * Date:     2019/5/8 9:02
 * Description: Convert Sorted List to Binary Search Tree
 *
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted linked list: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * Difficulty: Medium
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        //将链表转化为数组
        int size = 0;
        ListNode node = head;
        while (node != null){
            size++;
            node = node.next;
        }
        int[] arr = new int[size];
        ListNode temNode = head;
        int index = 0;
        while (temNode != null){
            arr[index] = temNode.val;
            index++;
            temNode = temNode.next;
        }
        return buildTree(arr,0,arr.length - 1);
    }

    //构建树 数组是树的前序遍历 中间值则为平衡二叉树的根 分别递归左右树即可
    private TreeNode buildTree(int[] arr, int start, int end) {
        if (start > end) return null;
        int rootIndex = (start + end) / 2;
        TreeNode treeNode = new TreeNode(arr[rootIndex]);
        treeNode.left = buildTree(arr, start, rootIndex - 1);
        treeNode.right = buildTree(arr, rootIndex + 1, end);
        return treeNode;
    }
}
