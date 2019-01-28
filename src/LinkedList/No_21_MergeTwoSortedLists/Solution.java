package LinkedList.No_21_MergeTwoSortedLists;

import LinkedList.ListNode;

/**
 * FileName: Solution
 * Author:   mac
 * Date:     2019-01-25 10:09
 * Description: MergeTwoSortedLists
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else {
            getLastNode(l1).next = l2;//先将两个链表相连接
            return getMiniNode(l1);
        }
    }

    //用递归方式找到链表最后一个值
    private ListNode getLastNode(ListNode node) {
        if (node.next == null)
            return node;
        return getLastNode(node.next);
    }


    private ListNode getMiniNode(ListNode node) {
        if (node == null || node.next == null)
            return node;
        ListNode cur, tail = null;
        cur = node;
        while(cur.next != tail) {
            while(cur.next != tail) {
                if (cur.val > cur.next.val) {
                    int tem = cur.val;
                    cur.val = cur.next.val;
                    cur.next.val = tem;
                }
                cur = cur.next;//判断大小之后，将指针指向下一个（也就是刚才比较的最大的那个节点）
            }
            tail = cur; //一轮比较之后 最后一个就是最大的那个 所以再循环 只需要判断节点下一个是不是依次循环后最大的那个节点
            cur = node; //将指针重新回到第一个
        }
        return node;
    }
}
