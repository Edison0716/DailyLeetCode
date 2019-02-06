package LinkedList.No_83_Remove_Duplicates_from_Sorted_List;

import LinkedList.ListNode;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-02-06 10:12
 * Description: Remove Nth Node From End of List
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 * <p>
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = head;
        while (dummy != null && dummy.next != null) {
            if (dummy.val == dummy.next.val)
                dummy.next = dummy.next.next;
            else
                dummy = dummy.next;
        }
        return head;
    }
}
