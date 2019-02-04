package LinkedList.No_234_Palindrome_Linked_List;


import LinkedList.ListNode;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-02-04 10:18
 * Description: Palindrome Linked List
 * <p>
 * Given a singly linked list, determine if it is a palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2
 * Output: false
 * Example 2:
 * <p>
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */

public class Solution {
    public boolean isPalindrome(ListNode head) {

        if (head == null){
            return true;
        }

        ListNode middleNode = findMiddleNode(head);
        ListNode reverseMiddleLinkedList = reverseLinkedList(middleNode);

        while (head != null && reverseMiddleLinkedList != null) {
            if (head.val != reverseMiddleLinkedList.val) {
                return false;
            }
            head = head.next;
            reverseMiddleLinkedList = reverseMiddleLinkedList.next;
        }
        return true;
    }


    //快慢指针 找中点 一二步指针
    private ListNode findMiddleNode(ListNode head) {
        ListNode fp = head;

        while (fp.next != null && fp.next.next != null) {
            fp = fp.next.next;
            head = head.next;
        }

        fp = head.next;
        head.next = null;

        return fp;
    }


    //逆序链表
    private ListNode reverseLinkedList(ListNode tarNode) {
        LinkedList.No_206_ReverseLinkedList.Solution solution = new LinkedList.No_206_ReverseLinkedList.Solution();
        return solution.reverseList(tarNode);
    }
}
