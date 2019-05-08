package LinkedList.No_92_Reverse_Linked_List_II;

import LinkedList.ListNode;

/**
 * FileName: Solution
 * Author:   EdisonLi的Windows
 * Date:     2019/5/7 11:05
 * Description:
 * Reverse a linked list from position m to n. Do it in one-pass.
 * <p>
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 * Difficulty:Medium
 */
public class Solution {
    private ListNode startNode;
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m >= n) return head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        head = dummyHead;
        startNode = head;

        //找到断开的位置
        for (int i = 1; i < m; i++) startNode = startNode.next;
        //快慢指针
        ListNode slowP = startNode.next;
        ListNode fastP = startNode.next.next;
        ListNode temNode = slowP;

        int i = 0;
        while (i + m < n){
            //换位置
            slowP.next = fastP.next;
            fastP.next = temNode;
            temNode = fastP;
            fastP = slowP.next;
            i++;
        }
        //接骨
        startNode.next = temNode;
        return dummyHead.next;
    }
}
