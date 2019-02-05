package LinkedList.No_19_Remove_Nth_Node_From_End_of_List;

import LinkedList.ListNode;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-02-05 21:08
 * Description: Remove Nth Node From End of List
 * <p>
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * <p>
 * Example:
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * <p>
 * Given n will always be valid.
 * <p>
 * Follow up:
 * <p>
 * Could you do this in one pass?
 */

public class Solution {
    // 快慢指针 一个先走N步
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode node1, node2;
        node1 = dummy;
        node2 = dummy;

        for (int i = 0; i < n + 1; i++)
            node1 = node1.next;

        while (node1 != null) {

            node1 = node1.next;

            node2 = node2.next;

        }

        node2.next = node2.next.next;

        return dummy.next;
    }


    //算出总长度 用总长度减去n
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;
        length = getTheTotalLength(head,length);
        length -= n;

        ListNode node = dummy;
        while (length > 0) {
            length--;
            node = node.next;
        }
        node.next = node.next.next;
        return dummy.next;
    }

    private int getTheTotalLength(ListNode head,int length) {
        length++;
        if (head.next!=null){
            return getTheTotalLength(head.next,length);
        }else {
            return length;
        }
    }
}
