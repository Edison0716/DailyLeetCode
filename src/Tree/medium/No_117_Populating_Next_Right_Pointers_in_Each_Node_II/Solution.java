package Tree.medium.No_117_Populating_Next_Right_Pointers_in_Each_Node_II;


/**
 * FileName: Solution
 * Author:   EdisonLi的Windows
 * Date:     2019/6/5 9:57
 * Description:
 *
 * Given a binary tree
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 *
 *
 * Example:
 *
 *
 *
 * Input: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":null,"next":null,"right":{"$id":"6","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
 *
 * Output: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":null,"right":null,"val":7},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"6","left":null,"next":null,"right":{"$ref":"5"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"6"},"val":1}
 *
 * Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B.
 *
 *
 * Note:
 *
 * You may only use constant extra space.
 * Recursive approach is fine, implicit stack space does not count as extra space for this problem.
 *
 * Difficulty: Medium
 */
public class Solution {
    public Node connect(Node root) {
        Node dummyHead = new Node(0);
        Node pre = dummyHead;
        Node curr = root;
        while (curr != null) {
            if (curr.left != null) {
                pre.next = curr.left;
                pre = pre.next;
            }
            if (curr.right != null) {
                pre.next = curr.right;
                pre = pre.next;
            }
            curr = curr.next;
            if (curr == null) {
                //从头开始
                pre = dummyHead;
                curr = dummyHead.next;
                dummyHead.next = null;
            }
        }
        return root;
    }
}
