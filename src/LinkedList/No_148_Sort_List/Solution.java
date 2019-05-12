package LinkedList.No_148_Sort_List;

import LinkedList.ListNode;

import java.util.Arrays;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-05-12 10:27
 * Description: Sort List
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Example 1:
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 *
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */
public class Solution {

    //归并排序 理解不是很好
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0);
        ListNode p = l;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null)
            p.next = l1;
        if (l2 != null)
            p.next = l2;
        return l.next;
    }

    public ListNode sortList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        int length = 0;
        while (cur != null){
            length++;
            cur = cur.next;
        }
        int[] array = new int[length];
        int index = 0;
        cur = head;
        while (cur != null){
            array[index] = cur.val;
            cur = cur.next;
            index++;
        }
        Arrays.sort(array);
        cur = head;
        index = 0;
        while (cur != null){
            cur.val = array[index++];
            cur = cur.next;
        }
        return head;
    }
}
