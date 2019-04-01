package Tree.easy.No_235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree;


import Tree.TreeNode;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-03-22 21:41
 * Description: Lowest Common Ancestor of a Binary Search Tree
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * Example 2:
 * <p>
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 */

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == q || root == p) return root;//如果root 等于其中一个就是根了
        if (root.val > Math.max(p.val, q.val)) return lowestCommonAncestor(root.left, p, q); //若根节点都大于两个子节点 则 说明 最小的公共节点就在这个根节点的左侧
        if (root.val < Math.min(p.val,q.val)) return lowestCommonAncestor(root.right,p,q); // 反之亦然，若跟节点都大于两个子节点 说明最小的公共节点就在这个根节点的右侧 然后继续遍历即可
        else return root; //其他情况 都是证明这个是根节点 比如比其中一个大 另一个小
    }
}
