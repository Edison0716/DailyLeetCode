package Tree.easy.No_965_Univalued_Binary_Tree;

import Tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * FileName: Solution
 * Author:   mac
 * Date:     2019-02-25 16:39
 * Description: Univalued Binary Tree
 * Recently Review: 2019-05-11 08:52
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
    //法一：
    public boolean isUnivalTree(TreeNode root) {
        boolean isLeft = root.left == null || root.left.val == root.val && isUnivalTree(root.left);
        boolean isRight = root.right == null || root.right.val == root.val && isUnivalTree(root.right);
        return isLeft && isRight;
    }

    //法二：
    private List<Integer> mContainer = new ArrayList<>();
    public boolean isUnivalTree1(TreeNode root) {
        handleNodeToArray(root);
        for (int i = 0; i < mContainer.size(); i++) {

            for (int j = 1;j < mContainer.size();j++){
                if (!mContainer.get(i).equals(mContainer.get(j))){
                    return false;
                }
            }
        }
        return true;
    }
    private void handleNodeToArray(TreeNode root) {
        if (root == null) return;
        mContainer.add(root.val);
        handleNodeToArray(root.left);
        handleNodeToArray(root.right);
    }
}
