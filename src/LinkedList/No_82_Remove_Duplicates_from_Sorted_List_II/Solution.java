package LinkedList.No_82_Remove_Duplicates_from_Sorted_List_II;

import LinkedList.ListNode;

/**
 * FileName: Solution
 * Author:   EdisonLi的Windows
 * Date:     2019/6/5 17:35
 * Description: No.82 Remove Duplicates from Sorted List II
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * Example 2:
 * <p>
 * Input: 1->1->1->2->3
 * Output: 2->3
 * Difficulty: Medium
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode start = new ListNode(0);
        start.next = head;
        //之前的节点用来判断第一个重复的节点的前一个节点
        ListNode preNode = start;
        //移动的节点
        ListNode curNode = head;
        while (curNode != null) {
            //如果下一个节点不为空 并且 当前节点 等于下个节点
            if (curNode.next != null && curNode.val == curNode.next.val) {
                do {
                    curNode = curNode.next;
                }while (curNode.next != null && curNode.val == curNode.next.val);
                //删除相等的节点也就是越过
                preNode.next = curNode.next;
            }else {
                //不相等则移动 preNode
                preNode = curNode;
            }
            curNode = curNode.next;
        }
        return start.next;
    }

    //双指针 行不通
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
