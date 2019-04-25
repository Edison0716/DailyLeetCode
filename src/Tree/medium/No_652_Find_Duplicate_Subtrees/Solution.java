package Tree.medium.No_652_Find_Duplicate_Subtrees;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        return new ArrayList<TreeNode>();
    }
}
