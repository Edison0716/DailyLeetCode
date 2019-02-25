package Tree.No_965_Univalued_Binary_Tree;

import Tree.TreeNode;
import java.util.ArrayList;

/**
 * FileName: Solution
 * Author:   mac
 * Date:     2019-02-25 16:39
 * Description: Univalued Binary Tree
 * <p>
 * A binary tree is univalued if every node in the tree has the same value.
 * <p>
 * Return true if and only if the given tree is univalued.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: [1,1,1,1,1,null,1]
 * Output: true
 * Example 2:
 * <p>
 * <p>
 * Input: [2,2,2,5,2]
 * Output: false
 */
public class Solution {
    ArrayList<Integer> array;

    public boolean isUnivalTree(TreeNode root) {
        array = new ArrayList();
        convertToArray(root);
        for (int num : array) {
            if (num != array.get(0))
                return false;
        }
        return true;
    }

    private void convertToArray(TreeNode root) {
        if (root != null) {
            array.add(root.val);
            convertToArray(root.left);
            convertToArray(root.right);
        }
    }


    public boolean isUnivalTree1(TreeNode root) {
        boolean leftResult = (root.left == null || (root.val == root.left.val && isUnivalTree1(root.left)));
        boolean rightResult = (root.right == null || (root.val == root.right.val && isUnivalTree1(root.right)));
        return leftResult && rightResult;
    }
}
