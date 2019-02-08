package LinkedList.No_24_Swap_Nodes_in_Pairs;

import LinkedList.ListNode;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-02-08 09:47
 * Description: Swap Nodes in Pairs
 * <p>
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */

public class Solution {


    public ListNode swapPairs1(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        ListNode s;
        dummyHead.next = head;
        head = dummyHead;

        while (dummyHead.next != null && dummyHead.next.next != null) {
            //位置交换
            s = dummyHead.next.next;
            dummyHead.next.next = s.next;
            s.next = dummyHead.next;
            dummyHead.next = s;
            dummyHead = s.next;
        }

        return head.next;
    }


    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode temp = head;
        head = head.next;
        temp.next = head.next;
        head.next = temp;

        head.next.next = swapPairs(head.next.next);
        return head;
    }
}
