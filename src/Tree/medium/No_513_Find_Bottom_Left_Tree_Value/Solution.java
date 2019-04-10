package Tree.medium.No_513_Find_Bottom_Left_Tree_Value;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-04-10 10:55
 * Description: Maximum Binary Tree
 * Difficulty: Medium
 * Given a binary tree, find the leftmost value in the last row of the tree.
 *
 * Example 1:
 * Input:
 *
 *     2
 *    / \
 *   1   3
 *
 * Output:
 * 1
 * Example 2:
 * Input:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 *
 * Output:
 * 7
 *
 */
public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            root = queue.poll();

            if (root.right!=null){
                queue.add(root.right);//先判断右侧
            }
            if (root.left!=null){
                queue.add(root.left);//左侧为空 返回右子树
            }
        }
        return root.val;
    }


    public int findBottomLeftValue1(TreeNode root){
        return findBottomLeftValue1(root,1,new int[]{0,0});
    }

    private int findBottomLeftValue1(TreeNode root, int depth, int[] container) {
        if (container[1] < depth) {
            container[0] = root.val;
            container[1] = depth ;
        }

        if (root.left != null)  findBottomLeftValue1(root.left,depth + 1,container);

        if (root.right != null) findBottomLeftValue1(root.right, depth + 1,container);

        return container[0];
    }
}
