package LinkedList.No_82_Remove_Duplicates_from_Sorted_List_II;

import LinkedList.ListNode;

/**
 * FileName: Solution
 * Author:   EdisonLi的Windows
 * Date:     2019/6/5 17:35
 * Description: No.82 Remove Duplicates from Sorted List II
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *
 * Example 1:
 *
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * Example 2:
 *
 * Input: 1->1->1->2->3
 * Output: 2->3
 * Difficulty: Medium
 */
public class Solution {
    //双指针
//    public ListNode deleteDuplicates(ListNode head) {
//        ListNode dummyHead = head;
//        ListNode fastP = dummyHead;
//        ListNode slowP = dummyHead;
//        while (fastP != null && fastP.next != null){
//           fastP = fastP.next;
//           if (slowP == fastP){
//               slowP.next = null;
//           }
//        }
//    }
}
