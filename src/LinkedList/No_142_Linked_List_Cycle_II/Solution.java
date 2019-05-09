package LinkedList.No_142_Linked_List_Cycle_II;

import LinkedList.ListNode;

/**
 * FileName: Solution
 * Author:   EdisonLi的Windows
 * Date:     2019/5/9 13:37
 * Description: Linked List Cycle II
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * <p>
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 * <p>
 * Note: Do not modify the linked list.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 * <p>
 * <p>
 * <p>
 * <p>
 * Follow up:
 * Can you solve it without using extra space?
 * Difficulty: Medium
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fastP = head, slowP = head;

        while (fastP != null && fastP.next != null){
            fastP = fastP.next.next;
            slowP = slowP.next;
            //有环
            if (fastP == slowP) break;
        }

        if (fastP == null || fastP.next == null) return null;
        slowP = head;
        //快慢指针相等时则是环的起始点
        while (fastP != slowP){
            fastP = fastP.next;
            slowP = slowP.next;
        }
        return slowP;
    }
}
