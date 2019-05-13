package LinkedList.No_61_Rotate_List;


import LinkedList.ListNode;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-05-13 19:57
 * Description: Rotate List
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * Example 2:
 * <p>
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int length = 0;
        ListNode node = head;
        while (node != null){
            length++;
            node = node.next;
        }

        if (k % length == 0) return head;

        //旋转次数可能大于长度
        k %= length;

        //找到旋转点
        ListNode rotateList = head;

        int i = 1;
        while (i < length - k){
            rotateList = rotateList.next;
            i++;
        }

        ListNode pushToHeadNode = rotateList.next;
        //找到旋转过去的那一部分的尾节点
        ListNode pushToHeadNodeEnd = pushToHeadNode;
        while (pushToHeadNodeEnd.next != null){
            pushToHeadNodeEnd = pushToHeadNodeEnd.next;
        }
        //旋转点的下一个节点为null
        rotateList.next = null;
        //接到头部
        pushToHeadNodeEnd.next = head;

        return pushToHeadNode;
    }
}
