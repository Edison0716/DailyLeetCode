package Tree.medium.No_652_Find_Duplicate_Subtrees;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FileName: Solution
 * Author:   EdisonLi的Windows
 * Date:     2019/4/25 17:54
 * Description: 652. Find Duplicate Subtrees
 *
 * Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.
 *
 * Two trees are duplicate if they have the same structure with same node values.
 *
 * Example 1:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   2   4
 *        /
 *       4
 * The following are two duplicate subtrees:
 *
 *       2
 *      /
 *     4
 * and
 *
 *     4
 * Therefore, you need to return above trees' root in the form of a list.
 *
 * Difficulty: Medium
 */
public class Solution {
    //序列化
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> resArray = new ArrayList<>();
        if (root == null) return resArray;
        Map<String,List<TreeNode>> map = new HashMap<>();
        handleNodeToString(root,map);
        for (List<TreeNode> nodes:map.values()){
            if (nodes.size()>1) resArray.add(nodes.get(0));
        }
        return resArray;
    }

    //将每一个左右节点的值都保存 成一个字符串 作为Key
    private String handleNodeToString(TreeNode root, Map<String, List<TreeNode>> map) {
        if (root == null) return "";
        String s = "##" + handleNodeToString(root.left,map) + root.val + handleNodeToString(root.right,map) + "##";
        if (!map.containsKey(s)) map.put(s,new ArrayList<>());
        map.get(s).add(root);
        return s;
    }
}
