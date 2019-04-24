package Tree.medium.No_863_All_Nodes_Distance_K_in_Binary_Tree;

import Tree.TreeNode;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FileName: Solution
 * Author:   EdisonLi的Windows
 * Date:     2019/4/23 16:56
 * Description:
 * <p>
 * We are given a binary tree (with root node root), a target node, and an integer value K.
 * <p>
 * Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * <p>
 * Output: [7,4,1]
 * <p>
 * Explanation:
 * The nodes that are a distance 2 from the target node (with value 5)
 * have values 7, 4, and 1.
 * <p>
 * <p>
 * <p>
 * Note that the inputs "root" and "target" are actually TreeNodes.
 * The descriptions of the inputs above are just serializations of these objects.
 * <p>
 * <p>
 * Note:
 * <p>
 * The given tree is non-empty.
 * Each node in the tree has unique values 0 <= node.val <= 500.
 * The target node is a node in the tree.
 * 0 <= K <= 1000.
 * <p>
 * Difficulty: Medium
 * <p>
 * hint:
 * (深度优先遍历) O(n)O(n)
 * 我们需要做若干次深度优先遍历。
 * 第一次需要定位 target 的具体位置，并按顺序记录其到根结点的路径。路径中的每个点，用一个二元组表示，分别为点的指针，和一个布尔值。其中布尔值为 true 代表 target 是在当前结点的左侧，否则在右侧。路径不包括 target 本身。
 * 然后，我们顺着路径，从底向上。如果路径上当前的点已经和 target 距离为 K，则保存当前结点，然后退出循环。否则，如果布尔值为 true，则从右侧开始深度优先遍历找距离 target 为 K 的结点，否则从左侧开始找。
 * 最后，从 target 开始深度优先遍历找答案。
 * 时间复杂度
 * 第一次深度优先遍历每个结点最多遍历一次，故时间复杂度为 O(n)O(n)。
 * 从路径上的结点开始做的深度优先遍历，并不会重复访问一个结点多次，与最后从 target 开始的遍历也不会重复，故总时间复杂度仍然为 O(n)O(n)。
 * 空间复杂度
 * 需要一个数组来保存答案，空间可能达到 O(n)O(n)。此外，需要 O(h)O(h) 的空间来保存路径，以及需要 O(h)O(h) 的空间给系统栈使用。故总空间复杂度为 O(n)O(n)。
 */
public class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> resArray = new ArrayList<>();
        List<TreeNode> visitContainer = new ArrayList<>();
        if (root == null) return resArray;
        findNodes(target, resArray, K, visitContainer);
        distanceKHelper(root, target, resArray, K, visitContainer);
        return resArray;
    }

    //往下找
    private void findNodes(TreeNode node, List<Integer> resArray, int k, List<TreeNode> visitContainer) {
        if (node == null || k < 0 || visitContainer.contains(node)) return;
        if (k == 0) {
            resArray.add(node.val);
            return;
        }
        visitContainer.add(node);
        findNodes(node.left, resArray, k - 1, visitContainer);
        findNodes(node.right, resArray, k - 1, visitContainer);
    }


    private void distanceKHelper(TreeNode root, TreeNode target, List<Integer> res, int k, List<TreeNode> visited) {
        if (root == null || k < 0) return;
        //找目标的父亲
        TreeNode parent = findParent(root, target);
        //这里两行是关键点  难理解的地方
        //从父亲的节点开始往下找 左右子树 但是左右子树必然有一支已经递归过了也找到了 所以visitContainer的作用就体现出来了
        //visitContainer.contains(node) 走过了就return
        findNodes(parent, res, k - 1, visited);
        //找祖父节点中是否有符合条件的 也是最难想的 递归找每一个节点的父亲 想明白了挺有意思的 哈哈
        distanceKHelper(root, parent, res, k - 1, visited);
    }


    private TreeNode findParent(TreeNode node, TreeNode targetNode) {
        if (node == null) return null;
        if (node.left == targetNode || node.right == targetNode) return node;
        TreeNode leftNode = findParent(node.left, targetNode);
        TreeNode rightNode = findParent(node.right, targetNode);
        if (leftNode != null && rightNode != null) return node;
        return leftNode == null ? rightNode : leftNode;
    }


//    private List<Integer> resArray = new ArrayList<>();
//    private HashMap<TreeNode,Integer> temMap = new HashMap<>();
//    private TreeNode node;
//
//    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
//        handleDistanceK(root, target, K, 0);
//        findPrevious(root,K,0);
//        return resArray;
//    }
//
//    private void findPrevious(TreeNode root, int k,int depth) {
//        if (root == null) return;
//
//        if (Math.abs(temMap.get(node) - k) == depth){
//            resArray.add(root.val);
//        }
//
//        findPrevious(root.left, k,depth + 1);
//        findPrevious(root.right, k,depth + 1);
//    }
//
//    private void handleDistanceK(TreeNode root, TreeNode target, int k, int depth) {
//        if (root == null) return;
//
//
//
//
//        //往下找
//        if (root == target){
//            findResult(root, k, 0);
//            this.node = root;
//            temMap.put(root,depth);
//        }
//
//        handleDistanceK(root.left, target, k,depth + 1);
//        handleDistanceK(root.right, target, k,depth + 1);
//    }
//
//
//    //往下找
//    private void findResult(TreeNode root, int k, int depth) {
//        if (root == null) return;
//        if (depth == k)
//            resArray.add(root.val);
//        findResult(root.left, k, depth + 1);
//        findResult(root.right, k, depth + 1);
//    }
}
