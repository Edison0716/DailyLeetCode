package LinkedList.No_86_Partition_List;

import LinkedList.ListNode;

/**
 * FileName: Solution
 * Author:   EdisonLi的Windows
 * Date:     2019/5/7 16:12
 * Description: Partition List
 * <p>
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * Example:
 * <p>
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 * <p>
 * Difficulty: Medium
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallPart = new ListNode(0); //小于X部分
        ListNode small = smallPart;
        ListNode bigPart = new ListNode(0);//大于等于X部分
        ListNode big = bigPart;
        while (head != null){
            if (head.val >= x){
                big.next = head;
                big = big.next;
            }else {
                small.next = head;
                small = small.next;
            }
            head = head.next;
        }
        big.next = null;
        small.next = bigPart.next;
        return smallPart.next;
    }
}
