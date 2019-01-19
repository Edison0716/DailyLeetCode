package LinkedList.No_2_AddTwoNumbers;

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
}
