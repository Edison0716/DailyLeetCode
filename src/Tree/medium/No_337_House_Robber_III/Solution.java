package Tree.medium.No_337_House_Robber_III;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * FileName: Solution
 * Author:   EdisonLi的Windows
 * Date:     2019/4/19 17:07
 * Description:
 *
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
 *
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * Example 2:
 *
 * Input: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 *
 * Difficulty: Medium
 */
public class Solution {

    public int rob(TreeNode root) {
        return robDFS(root)[1];
    }

    int[] robDFS(TreeNode node) {
        int[] res = new int[2];
        if (node == null) return res;
        int[] l = robDFS(node.left);
        int[] r = robDFS(node.right);
        res[0] = l[1] + r[1];
        res[1] = Math.max(res[0], l[0] + r[0] + node.val);
        return res;
    }


//    public int rob(TreeNode root) {
//        List<List<Integer>> resArray = new ArrayList<>();
//        handleLevelOrder(root,resArray,0);
//        int result1 = 0;
//        for (int i = 0;i<resArray.size();i+=2){
//            for (int j :resArray.get(i)){
//                result1 += j;
//            }
//        }
//
//        int result2 = 0;
//        for (int i = 1;i<resArray.size();i+=2){
//            for (int j :resArray.get(i)){
//                result2 += j;
//            }
//        }
//
//        return Math.max(result1,result2);
//    }
//
//    private void handleLevelOrder(TreeNode root, List<List<Integer>> resArray, int depth) {
//        if (root == null) return;
//        if (depth >= resArray.size())
//            resArray.add(new ArrayList<Integer>());
//
//        resArray.get(depth).add(root.val);
//
//        if (root.left != null)
//            handleLevelOrder(root.left,resArray,depth + 1);
//
//        if (root.right != null)
//            handleLevelOrder(root.right,resArray,depth + 1);
//    }


//    public int rob(TreeNode root) {
//        HashMap<Integer,Integer> temp = new HashMap<>();
//        handleRob(root,temp,0);
//
//        int size = temp.size();
//        int reason1 = 0;
//        for (int i = 0; i < size; i += 2){
//            reason1 += temp.get(i);
//        }
//
//        int reason2 = 0;
//        for (int j = 1; j < size; j += 2){
//            reason2 += temp.get(j);
//        }
//
//        return Math.max(reason2,reason1);
//    }
//
//    private void handleRob(TreeNode root,HashMap<Integer,Integer> temp, int depth) {
//        if (root == null) return;
//
//        if (temp.containsKey(depth)) {
//            temp.put(depth,temp.get(depth) + root.val);
//        }else {
//            temp.put(depth,root.val);
//        }
//
//        if (root.left != null)
//            handleRob(root.left,temp,depth + 1);
//
//        if (root.right != null)
//            handleRob(root.right,temp,depth + 1);
//
//    }

}
