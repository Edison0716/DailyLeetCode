package Tree.easy.No_590_N_ary_Tree_Postorder_Traversal;

import Tree.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * FileName: Solution
 * Author:   mac
 * Date:     2019-02-28 10:10
 * Description: N-ary Tree Postorder Traversal
 * <p>
 * Given an n-ary tree, return the postorder traversal of its nodes' values.
 * <p>
 * For example, given a 3-ary tree:
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Return its postorder traversal as: [5,6,3,2,4,1].
 * <p>
 * <p>
 * Note:
 * <p>
 * Recursive solution is trivial, could you do it iteratively?
 */
public class Solution {
    public ArrayList<Integer> resArray = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if (root == null) return resArray;
        for (Node node : root.children) {
            postorder(node);
        }
        resArray.add(root.val);
        return resArray;
    }


    public List<Integer> postorder1(Node root) {
        if (root == null)
            return resArray;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            root = stack.pop();

            resArray.add(root.val);

            for (Node node : root.children) {
                stack.add(node);
            }


        }
        Collections.reverse(resArray);
        return resArray;
    }

}
