package Tree.easy.No_589_N_ary_Tree_Preorder_Traversal;

import Tree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * FileName: Solution
 * Author:   mac
 * Date:     2019-02-27 10:17
 * Description: N-ary Tree Preorder Traversal
 * Given an n-ary tree, return the preorder traversal of its nodes' values.
 * <p>
 * For example, given a 3-ary tree:
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Return its preorder traversal as: [1,3,5,6,2,4].
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * Recursive solution is trivial, could you do it iteratively?
 */
public class Solution {
    public List<Integer> resArray = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root == null)
            return resArray;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            root = stack.pop();
            resArray.add(root.val);

            for (int i = root.children.size() - 1; i >= 0; i--) {
                stack.add(root.children.get(i));
            }
        }

        return resArray;
    }

    public List<Integer> preorder1(Node root) {

        if (root == null)
            return resArray;

        resArray.add(root.val);

        for (Node roots : root.children)
            preorder1(roots);

        return resArray;
    }
}
