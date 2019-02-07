package LinkedList.No_2_AddTwoNumbers;

import LinkedList.ListNode;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-01-19 17:28
 * Description:
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }

        Long l1Num = listToLong(l1);
        Long l2Num = listToLong(l2);

        return longToList(l1Num + l2Num);
    }


    public Long listToLong(ListNode node) {
        long num = 0;
        long curr = 1;

        while (node != null) {
            num = num + node.val * curr;
            curr = curr * 10;
            node = node.next;
        }

        return num;
    }

    public ListNode longToList(long num) {
        ListNode node = new ListNode(-1);
        node.next = null;
        ListNode resNode = node;

        resNode.val = (int) (num % 10);
        num = num / 10;

        while (num > 0) {
            ListNode nextCode = new ListNode((int) (num % 10));
            nextCode.next = null;
            resNode.next = nextCode;
            num = num / 10;
            resNode = resNode.next;
        }
        return node;
    }

//    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
//        ListNode dummy = new ListNode(-1);
//        ListNode cur = dummy;
//        int carry = 0;
//        while (l1 != null || l2 != null) {
//            int d1 = l1 == null ? 0 : l1.val;
//            int d2 = l2 == null ? 0 : l2.val;
//            int sum = d1 + d2 + carry;
//            carry = sum >= 10 ? 1 : 0;
//            cur.next = new ListNode(sum % 10);
//            cur = cur.next;
//            if (l1 != null) l1 = l1.next;
//            if (l2 != null) l2 = l2.next;
//        }
//        if (carry == 1) cur.next = new ListNode(1);
//        return dummy.next;
//    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        int curry = 0;
        while (l1 != null || l2 != null) {
            int d1 = l1 == null ? 0 : l1.val;
            int d2 = l2 == null ? 0 : l2.val;
            int sum = d1 + d2 + curry;
            curry = sum >= 10 ? 1 : 0;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

        }

        if (curry == 1) cur.next = new ListNode(1);

        return dummyHead.next;
    }

}
