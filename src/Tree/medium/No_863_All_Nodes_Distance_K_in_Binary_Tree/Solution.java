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
 *
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
 *
 */
public class Solution {
    private List<Integer> resArray = new ArrayList<>();
    private HashMap<TreeNode,Integer> temMap = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        handleDistanceK(root, target, K);
        return resArray;
    }

    private void handleDistanceK(TreeNode root, TreeNode target, int k) {
        if (root == null) return;

        //todo 往右侧找


        //往下找
        if (root == target)
            findResult(root, k, 0);

        handleDistanceK(root.left, target, k);
        handleDistanceK(root.right, target, k);
    }


    //往下找
    private void findResult(TreeNode root, int k, int depth) {
        if (root == null) return;
        if (depth == k)
            resArray.add(root.val);
        findResult(root.left, k, depth + 1);
        findResult(root.right, k, depth + 1);
    }
}
