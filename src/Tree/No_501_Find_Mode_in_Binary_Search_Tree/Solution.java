package Tree.No_501_Find_Mode_in_Binary_Search_Tree;


import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-03-28 12:20
 * Description: Find Mode in Binary Search Tree
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * <p>
 * For example:
 * Given BST [1,null,2,2],
 * <p>
 *    1
 *     \
 *      2
 *     /
 *    2
 * <p>
 * <p>
 * return [2].
 * <p>
 * Note: If a tree has more than one mode, you can return them in any order.
 * <p>
 * Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
 */

public class Solution {
    private Integer tem = null;
    private int max = 0;
    private int count = 1;

    public int[] findMode(TreeNode root) {
        List<Integer> listNum = new ArrayList<Integer>();

        handleMaxTimes(root, listNum);

        int[] res = new int[listNum.size()];

        for (int i = 0; i < listNum.size(); ++i) res[i] = listNum.get(i);

        return res;
    }

    private void handleMaxTimes(TreeNode root, List<Integer> listNum) {
        if (root == null) return;
        handleMaxTimes(root.left, listNum);

        if (tem != null) {
            //判断下一次复现
            if (tem == root.val) {
                count++;
            } else {
                //第一次出现
                count = 1;
            }
        }

        if (count > max) { //找到频率最多的 并且比上次频次多
            max = count;
            listNum.clear();//清空
            listNum.add(root.val);
        } else if (count == max) {
            listNum.add(root.val);
        }

        tem = root.val;

        handleMaxTimes(root.right, listNum);
    }
}
