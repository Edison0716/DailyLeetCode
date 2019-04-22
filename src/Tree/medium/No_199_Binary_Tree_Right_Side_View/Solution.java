package Tree.medium.No_199_Binary_Tree_Right_Side_View;


import Tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019/4/21 17:57
 * Description:
 *
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 * Example:
 *
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 * Difficulty: Medium
 *
 */

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> resArray = new ArrayList<>();
        handleNode1(root,resArray,0);
        return resArray;
    }

    private void handleNode1(TreeNode curNode, List<Integer> resArray, int depth) {
        if (curNode == null) return;

        //深度与当前集合size一致则添加
        if (depth == resArray.size())
            resArray.add(curNode.val);

        //先遍历右  深度加一
        handleNode1(curNode.right,resArray,depth + 1);
        handleNode1(curNode.left,resArray,depth + 1);
    }


    //错误范例  [1,2,3,4] 失败
    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> resArray = new ArrayList<>();
        handleNode(root,resArray);
        return resArray;
    }

    private void handleNode(TreeNode root, List<Integer> resArray) {
        if (root == null) return;
        resArray.add(root.val);
        if (root.right == null){
            handleNode(root.left,resArray);
        }else {
            handleNode(root.right,resArray);
        }
    }
}
