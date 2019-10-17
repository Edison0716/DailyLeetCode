package LinkedList.No_206_ReverseLinkedList;

import LinkedList.ListNode;

/**
 * FileName: Solution
 * Author:   mac
 * Date:     2019-01-29 10:27
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


public class Solution {

    //解法一 iterative： 1->2->3->null
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null){
            // 1 、先将cur的下个节点保存
            ListNode temNext = cur.next;
            // 3、处理操作 将当前的节点的指针指向之前上一次循环后的节点
            cur.next = prev;
            prev = cur;
            // 2、处理完cur 再将cur设置为之前的next节点
            cur = temNext;
        }

        return prev;
    }


    //解法二 recursive： 1->2->3->null
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null)
            return head;
        return getReverse(head, null);
    }

    private ListNode getReverse(ListNode cur, ListNode prev) {
        if (cur.next == null) {
            cur.next = prev;
            return cur;
        }
        ListNode n1 = cur.next;
        cur.next = prev;
        return getReverse(n1, cur);
    }
}
