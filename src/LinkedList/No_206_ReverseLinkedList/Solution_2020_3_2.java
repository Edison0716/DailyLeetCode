package LinkedList.No_206_ReverseLinkedList;

import LinkedList.ListNode;

/**
 * FileName: Solution
 * Author:   mac
 * Date:     2020-03-02 21:45
 * Description: ReverseLinkedList
 * <p>
 * Reverse a singly linked list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 * <p>
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */


public class Solution_2020_3_2 {
    public ListNode reverseList1(ListNode head) {
        ListNode preNode = null;
        ListNode curNode = head;
        while (curNode != null) {
            ListNode tem = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = tem;
        }
        return preNode;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        return handleList(head,null);
    }
    private ListNode handleList(ListNode cur,ListNode prev) {
        if (cur.next == null){
            cur.next = prev;
            return cur;
        }
        ListNode tem = cur.next;
        cur.next = prev;
        return handleList(tem,cur);
    }
}
