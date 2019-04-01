package Tree.easy.No_559_Maximum_Depth_of_N_ary_Tree;

import Tree.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * FileName: Solution
 * Author:   mac
 * Date:     2019-03-01 11:04
 * Description: Maximum Depth of N-ary Tree
 * <p>
 * Given a n-ary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * For example, given a 3-ary tree:
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * We should return its max depth, which is 3.
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * The depth of the tree is at most 1000.
 * The total number of nodes is at most 5000.
 */
public class Solution {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int maxDepth = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node currentRoot = queue.poll();
                for (Node node:currentRoot.children){
                    queue.offer(node);
                }
            }
            maxDepth++;
        }
        return maxDepth;
    }
}
