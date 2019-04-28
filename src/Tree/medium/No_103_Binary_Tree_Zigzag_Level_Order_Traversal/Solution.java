package Tree.medium.No_103_Binary_Tree_Zigzag_Level_Order_Traversal;


import Tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-04-28 20:38
 * Description: Binary Tree Zigzag Level Order Traversal
 * Difficulty: Medium
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 */
public class Solution {
    private HashMap<Integer, ArrayList<Integer>> container = new HashMap<>();
    private ArrayList<List<Integer>> resArray = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        handleRoot(root,0);
        for (int i = 0; i < container.size(); i++){
            ArrayList tem = new ArrayList();
            if (i % 2 != 0){
                ArrayList<Integer> arrayList = container.get(i);
                Collections.reverse(arrayList);
                tem.addAll(arrayList);
            }else {
                tem.addAll(container.get(i));
            }
            resArray.add(tem);
        }
        return resArray;
    }

    private void handleRoot(TreeNode root, int depth) {
        if (root == null) return;
        if (container.containsKey(depth)){
            container.get(depth).add(root.val);
        }else {
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(root.val);
            container.put(depth,arrayList);
        }
        handleRoot(root.left,depth + 1);
        handleRoot(root.right,depth + 1);
    }
}
