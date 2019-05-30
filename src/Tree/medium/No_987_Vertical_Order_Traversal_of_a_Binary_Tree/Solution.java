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
    /**
     * Tips:
     * 1> PriorityQueue是一种无界的，线程不安全的队列
     * 2> PriorityQueue是一种通过数组实现的，并拥有优先级的队列
     * 3> PriorityQueue存储的元素要求必须是可比较的对象， 如果不是就必须明确指定比较器
     *
     * TreeMap 与 HashMap
     * 两者都是非线程安全
     * HashMap Key 对应HashCode 无序
     * TreeMap 固定顺序
     * 对于有序队列用TreeMap保证顺序
     *
     * .两种常规Map实现
     *
     * HashMap：基于哈希表实现。使用HashMap要求添加的键类明确定义了hashCode()和equals()[可以重写hashCode()和equals()]，为了优化HashMap空间的使用，您可以调优初始容量和负载因子。
     *
     * (1)HashMap(): 构建一个空的哈希映像
     * (2)HashMap(Map m): 构建一个哈希映像，并且添加映像m的所有映射
     * (3)HashMap(int initialCapacity): 构建一个拥有特定容量的空的哈希映像
     * (4)HashMap(int initialCapacity, float loadFactor): 构建一个拥有特定容量和加载因子的空的哈希映像
     *
     * TreeMap：基于红黑树实现。TreeMap没有调优选项，因为该树总处于平衡状态。
     *
     * (1)TreeMap():构建一个空的映像树
     * (2)TreeMap(Map m): 构建一个映像树，并且添加映像m中所有元素
     * (3)TreeMap(Comparator c): 构建一个映像树，并且使用特定的比较器对关键字进行排序
     * (4)TreeMap(SortedMap s): 构建一个映像树，添加映像树s中所有映射，并且使用与有序映像s相同的比较器排序
     */
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
