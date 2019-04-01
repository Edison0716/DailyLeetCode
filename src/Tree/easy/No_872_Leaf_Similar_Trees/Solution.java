package Tree.easy.No_872_Leaf_Similar_Trees;


import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-03-03 22:11
 * Description: Leaf-Similar Trees
 * Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.
 * <p>
 * <p>
 * <p>
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 * <p>
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 * <p>
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * Both of the given trees will have between 1 and 100 nodes.
 */

public class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        findDepthFirst(root1, arr1);
        findDepthFirst(root2, arr2);

        return arr1.equals(arr2);
    }


    public void findDepthFirst(TreeNode node, List<Integer> leafList) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                leafList.add(node.val);
            }
            findDepthFirst(node.left, leafList);
            findDepthFirst(node.right, leafList);
        }
    }
}
