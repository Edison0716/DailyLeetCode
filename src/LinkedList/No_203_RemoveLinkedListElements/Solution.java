package LinkedList.No_203_RemoveLinkedListElements;

import LinkedList.ListNode;

/**
 * FileName: Solution
 * Author:   mac
 * Date:     2019-01-17 15:51
 * Description:
 *
 * Remove all elements from a linked list of integers that have value val.
 * <p>
 * Example:
 * <p>
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 *
 * the Solution is we can create a fake header node ,so we can according to the fake node to find the previous node of current node.
 *
 */

public class Solution {
    public ListNode removeElements(ListNode head, int val){
//        1、
//        ListNode dummyHead = new ListNode(-1);
//        dummyHead.next = head;
//        ListNode prevNode = dummyHead;
//        while (prevNode.next != null) {
//            if (prevNode.next.val == val){
//                prevNode.next = prevNode.next.next;
//            }else {
//                prevNode = prevNode.next;
//            }
//        }
//        2、
        if (head == null)
            return null;

        ListNode res = removeElements(head.next, val);

        if (res.val == val){
            return res;
        }else {
            head.next = res;
            return head;
        }
    }
}
