package Tree.medium.No_865_Smallest_Subtree_with_all_the_Deepest_Nodes;

import Tree.TreeNode;

import java.util.HashMap;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-04-13 19:06
 * Description: Maximum Binary Tree
 * Difficulty: Medium
 * Given a binary tree rooted at root, the depth of each node is the shortest distance to the root.
 * <p>
 * A node is deepest if it has the largest depth possible among any node in the entire tree.
 * <p>
 * The subtree of a node is that node, plus the set of all descendants of that node.
 * <p>
 * Return the node with the largest depth such that it contains all the deepest nodes in its subtree.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [3,5,1,6,2,0,8,null,null,7,4]
 * Output: [2,7,4]
 * Explanation:
 * <p>
 * <p>
 * <p>
 * We return the node with value 2, colored in yellow in the diagram.
 * The nodes colored in blue are the deepest nodes of the tree.
 * The input "[3, 5, 1, 6, 2, 0, 8, null, null, 7, 4]" is a serialization of the given tree.
 * The output "[2, 7, 4]" is a serialization of the subtree rooted at the node with value 2.
 * Both the input and output have TreeNode type.
 * <p>
 * <p>
 * Note:
 * <p>
 * The number of nodes in the tree will be between 1 and 500.
 * The values of each node are unique.
 */
public class Solution {

    // Solution 1  O(N^2)
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int leftDepth = findMaxDepth(root.left);
        int rightDepth = findMaxDepth(root.right);
        //判断左侧树与右侧树谁大 就说明结果树在哪一侧
        if (leftDepth == rightDepth) return root; //直到递归 相等的话就找到最深的小子树了
        else if (leftDepth > rightDepth) return subtreeWithAllDeepest(root.left);
        else return subtreeWithAllDeepest(root.right);
    }

    private int findMaxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(findMaxDepth(root.left) + 1, findMaxDepth(root.right) + 1);//找大的
    }


    // Solution 2 O(N)
    public TreeNode subtreeWithAllDeepest1(TreeNode root) {
        if (root == null)
            return null;
        HashMap<TreeNode,Integer> container = new HashMap<>();
        depth(root,container);
        return dfs(root,container);
    }

    //深度遍历 借助HashMap 找最大深度  类似中间人操作
    public int depth(TreeNode root, HashMap<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        int max = Math.max(depth(root.left, map) + 1, depth(root.right, map) + 1);
        map.put(root, max);
        return max;
    }

    //执行返回res操作
    public TreeNode dfs(TreeNode root, HashMap<TreeNode, Integer> map) {
        int depthLeft = depth(root.left, map);
        int depthRight = depth(root.right, map);

        if (depthLeft == depthRight) return root;
        else if (depthLeft > depthRight) return dfs(root.left,map);
        else return dfs(root.right,map);
    }
}
