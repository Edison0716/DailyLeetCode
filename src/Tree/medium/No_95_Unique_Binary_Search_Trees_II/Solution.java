package Tree.medium.No_95_Unique_Binary_Search_Trees_II;

import Tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * FileName: Solution
 * Author:   EdisonLi的Windows
 * Date:     2019/5/10 13:39
 * Description: Unique Binary Search Trees II
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * Difficulty: Medium
 */

public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return handleGenerateTrees( 1, n);
    }

    private List<TreeNode> handleGenerateTrees(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            //左子树递归
            List<TreeNode> smallNodes = handleGenerateTrees(start, i - 1);
            //右子树递归
            List<TreeNode> bigNodes = handleGenerateTrees(i + 1, end);
            for (TreeNode smallNode : smallNodes) {
                for (TreeNode bigNode : bigNodes) {
                    //每一个值都可以作为树的一个根
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = smallNode;
                    treeNode.right = bigNode;
                    res.add(treeNode);
                }
            }
        }
        return res;
    }
}
