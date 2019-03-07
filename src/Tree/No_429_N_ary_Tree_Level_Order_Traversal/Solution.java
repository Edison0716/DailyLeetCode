package Tree.No_429_N_ary_Tree_Level_Order_Traversal;

import Tree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * FileName: Solution
 * Author:   mac
 * Date:     2019-03-07 11:21
 * Description: N-ary Tree Level Order Traversal
 * <p>
 * Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * <p>
 * For example, given a 3-ary tree:
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * We should return its level order traversal:
 * <p>
 * [
 * [1],
 * [3,2,4],
 * [5,6]
 * ]
 * <p>
 * <p>
 * Note:
 * <p>
 * The depth of the tree is at most 1000.
 * The total number of nodes is at most 5000.
 */
public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> resArray = new LinkedList<>();
        if (root == null) return resArray;

        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root); //在队尾插入元素

        while (!nodeQueue.isEmpty()) {
            List<Integer> curLevelNodes = new LinkedList<>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                Node curNode = nodeQueue.poll();//取 注意 poll 操作导致队列出栈
                curLevelNodes.add(curNode.val);
                //遍历所有的当前子树的子树
                for (Node child : curNode.children)
                    nodeQueue.offer(child);
            }
            resArray.add(curLevelNodes);
        }
        return resArray;
    }
}
