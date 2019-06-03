package Tree.medium.No_116_Populating_Next_Right_Pointers_in_Each_Node;

/**
 * FileName: Solution
 * Author:   EdisonLi的Windows
 * Date:     2019/6/3 13:41
 * Description: 116. Populating Next Right Pointers in Each Node
 * <p>
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * <p>
 * <p>
 * Input: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":{"$id":"6","left":null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
 * <p>
 * Output: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":{"$id":"6","left":null,"next":null,"right":null,"val":7},"right":null,"val":6},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":"6"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"val":1}
 * <p>
 * Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B.
 * <p>
 * <p>
 * Note:
 * <p>
 * You may only use constant extra space.
 * Recursive approach is fine, implicit stack space does not count as extra space for this problem.
 * <p>
 * Difficulty: Medium
 */
public class Solution {

    //法一
    public Node connect1(Node root) {
        Node startNode = root;
        while (startNode != null) {
            Node temRoot = startNode;
            while (temRoot != null) {
                if (temRoot.left != null) temRoot.left.next = temRoot.right;
                if (temRoot.right != null && temRoot.next != null) temRoot.right.next = temRoot.next.left;

                temRoot = temRoot.next;
            }
            startNode = startNode.left;
        }
        return root;
    }

    //法二
    public Node connect2(Node root) {
        if (root == null) return null;
        handleNode(root.left, root.right);
        return root;
    }

    private void handleNode(Node node1, Node node2) {
        if (node1 == null) return;
        node1.next = node2;
        handleNode(node1.left, node1.right);
        handleNode(node2.left, node2.right);
        handleNode(node1.right, node2.left);
    }
}
