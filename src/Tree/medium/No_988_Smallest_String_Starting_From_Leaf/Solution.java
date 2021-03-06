package Tree.medium.No_988_Smallest_String_Starting_From_Leaf;

import Tree.TreeNode;

/**
 * FileName: Solution
 * Author:   EdisonLi的Windows
 * Date:     2019/4/18 9:31
 * Description: 988. Smallest String Starting From Leaf
 * <p>
 * Given the root of a binary tree, each node has a value from 0 to 25 representing the letters 'a' to 'z': a value of 0 represents 'a', a value of 1 represents 'b', and so on.
 * <p>
 * Find the lexicographically smallest string that starts at a leaf of this tree and ends at the root.
 * <p>
 * (As a reminder, any shorter prefix of a string is lexicographically smaller: for example, "ab" is lexicographically smaller than "aba".  A leaf of a node is a node that has no children.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: [0,1,2,3,4,3,4]
 * Output: "dba"
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: [25,1,3,1,3,0,2]
 * Output: "adz"
 * Example 3:
 * <p>
 * <p>
 * <p>
 * Input: [2,2,1,null,1,0,null,0]
 * Output: "abc"
 * <p>
 * <p>
 * Note:
 * <p>
 * The number of nodes in the given tree will be between 1 and 8500.
 * Each node in the tree will have a value between 0 and 25.
 * <p>
 * Difficulty: Medium
 */
public class Solution {
    private String result = "~";

    public String smallestFromLeaf(TreeNode root) {
        handleMinimum(root, new StringBuilder());
        return result;
    }

    private void handleMinimum(TreeNode root, StringBuilder builder) {
        if (root == null) return;
        //根据 Ascll 判断
        builder.append((char) ('a' + root.val));
        if (root.left == null && root.right == null){
            builder.reverse();
            String tem = builder.toString();
            builder.reverse();
            if (tem.compareTo(result) < 0)
                result = tem;
        }
        handleMinimum(root.left, builder);
        handleMinimum(root.right, builder);
        builder.deleteCharAt(builder.length() - 1);
    }
}
