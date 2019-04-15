package Tree.medium.No_655_Print_Binary_Tree;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-04-15 20:06
 * Description: Print Binary Tree
 * Difficulty: Medium
 * Print a binary tree in an m*n 2D string array following these rules:
 *
 * The row number m should be equal to the height of the given binary tree.
 * The column number n should always be an odd number.
 * The root node's value (in string format) should be put in the exactly middle of the first row it can be put. The column and the row where the root node belongs will separate the rest space into two parts (left-bottom part and right-bottom part). You should print the left subtree in the left-bottom part and print the right subtree in the right-bottom part. The left-bottom part and the right-bottom part should have the same size. Even if one subtree is none while the other is not, you don't need to print anything for the none subtree but still need to leave the space as large as that for the other subtree. However, if two subtrees are none, then you don't need to leave space for both of them.
 * Each unused space should contain an empty string "".
 * Print the subtrees following the same rules.
 * Example 1:
 * Input:
 *      1
 *     /
 *    2
 * Output:
 * [["", "1", ""],
 *  ["2", "", ""]]
 * Example 2:
 * Input:
 *      1
 *     / \
 *    2   3
 *     \
 *      4
 * Output:
 * [["", "", "", "1", "", "", ""],
 *  ["", "2", "", "", "", "3", ""],
 *  ["", "", "4", "", "", "", ""]]
 * Example 3:
 * Input:
 *       1
 *      / \
 *     2   5
 *    /
 *   3
 *  /
 * 4
 * Output:
 *
 * [["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 *  ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 *  ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 *  ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
 * Note: The height of binary tree is in the range of [1, 10].
 */

public class Solution {
    //判断树的深度    2的深度次幂 - 1
    public List<List<String>> printTree(TreeNode root) {
        int height = getTreeHeight(root);
        int resArraySize = (int) Math.pow(2, height) - 1;
        List<List<String>> resArray = new ArrayList<>();

        //创建空集合
        for (int i = 0; i < height; i++) {
            List<String> temList = new ArrayList<>();
            for (int j = 0; j < resArraySize; j++)
                temList.add("");
            resArray.add(temList);
        }

        handleArray(resArray, root, 0, 0, resArraySize - 1);

        return resArray;
    }

    private void handleArray(List<List<String>> resArray, TreeNode root, int level, int left, int right) {
        if (root == null) return;
        int index = (left + right) / 2;//中间点
        resArray.get(level).set(index,root.val + "");
        handleArray(resArray, root.left, level + 1, left, index - 1);
        handleArray(resArray, root.right, level + 1, index + 1, right);
    }

    //递归得深度
    private int getTreeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getTreeHeight(root.left) + 1, getTreeHeight(root.right) + 1);
    }
}
