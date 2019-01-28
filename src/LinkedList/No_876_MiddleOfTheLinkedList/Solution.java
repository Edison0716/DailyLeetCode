package LinkedList.No_876_MiddleOfTheLinkedList;

import LinkedList.ListNode;

/**
 * FileName: Solution
 * Author:   mac
 * Date:     2019-01-28 10:08
 * Description: Middle of the Linked List
 * <p>
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 * <p>
 * If there are two middle nodes, return the second middle node.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,4,5]
 * Output: Node 3 from this list (Serialization: [3,4,5])
 * The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
 * Note that we returned a ListNode object ans, such that:
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
 * Example 2:
 * <p>
 * Input: [1,2,3,4,5,6]
 * Output: Node 4 from this list (Serialization: [4,5,6])
 * Since the list has two middle nodes with values 3 and 4, we return the second one.
 * <p>
 * <p>
 * Note:
 * <p>
 * The number of nodes in the given list will be between 1 and 100.
 */
public class Solution {
    int length = 0;

    //第一种方法 先获得链表长度 然后进行遍历
    public ListNode middleNode(ListNode head) {

        int nodeLength = getNodeLength(head);

        if (nodeLength % 2 != 0) {
            for (int i = 0; i <= nodeLength / 2; i++) {
                head = head.next;
            }
        } else {
            for (int i = 0; i < nodeLength / 2; i++) {
                head = head.next;
            }
        }

        return head;
    }

    private int getNodeLength(ListNode node) {
        if (node.next == null) {
            return length;
        } else {
            length++;
            return getNodeLength(node.next);
        }
    }

    //第二种方法 设置两个指针 一个一次走一步 另一个一次走两步 当第二个指针走完  第一个指针就在中间的节点了
    public ListNode middleNode1(ListNode head) {
        ListNode slowPoint = head, fastPoint = head;

        while (fastPoint != null && fastPoint.next != null) {
            fastPoint = fastPoint.next.next;
            slowPoint = slowPoint.next;
        }

        return slowPoint;
    }
}
