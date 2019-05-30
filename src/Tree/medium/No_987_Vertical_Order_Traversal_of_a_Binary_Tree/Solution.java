package Tree.medium.No_987_Vertical_Order_Traversal_of_a_Binary_Tree;

import Tree.TreeNode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * FileName: Solution
 * Author:   EdisonLi的Windows
 * Date:     2019/5/29 15:46
 * Description:
 * Given a binary tree, return the vertical order traversal of its nodes values.
 * <p>
 * For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).
 * <p>
 * Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, we report the values of the nodes in order from top to bottom (decreasing Y coordinates).
 * <p>
 * If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.
 * <p>
 * Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: [3,9,20,null,null,15,7]
 * Output: [[9],[3,15],[20],[7]]
 * Explanation:
 * Without loss of generality, we can assume the root node is at position (0, 0):
 * Then, the node with value 9 occurs at position (-1, -1);
 * The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
 * The node with value 20 occurs at position (1, -1);
 * The node with value 7 occurs at position (2, -2).
 * Difficulty: Medium
 */
public class Solution {
    private TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> container = new TreeMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> resArray = new ArrayList<>();

        if (root == null) return resArray;

        handleNode(root, 0, 0, container);

        //取答案
        for (TreeMap<Integer, PriorityQueue<Integer>> xValue : container.values()) {
            resArray.add(new ArrayList<>());
            for (PriorityQueue<Integer> yValue: xValue.values()){
                while (!yValue.isEmpty())
                    resArray.get(resArray.size() - 1).add(yValue.poll());
            }
        }

        return resArray;
    }

    private void handleNode(TreeNode root, int x, int y, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> container) {
        if (root == null) return;

        //判断是否存在X值
        if (!container.containsKey(x)) {
            container.put(x, new TreeMap<>());
        }

        //判断是否第一次出现X值
        if (!container.get(x).containsKey(y)) {
            container.get(x).put(y, new PriorityQueue<>());
        }

        //存入节点值
        container.get(x).get(y).offer(root.val);

        //左子树 横坐标 - 1 纵坐标 + 1
        handleNode(root.left, x - 1, y + 1, container);

        //右子树横坐标 + 1 纵坐标 + 1
        handleNode(root.right, x + 1, y + 1, container);
    }
}
