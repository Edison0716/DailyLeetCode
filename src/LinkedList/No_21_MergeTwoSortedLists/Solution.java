package LinkedList.No_21_MergeTwoSortedLists;

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
        if (l1 == null && l2 == null){
            return null;
        }

        else if (l1 == null){
            return l2;
        }

        else if (l2 == null){
            return l1;
        }

        else{
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
        if(node == null || node.next == null)  //链表为空或者仅有单个结点
            return node;
        ListNode cur, tail = null;
        cur = node;
        while(cur.next != tail){
            while(cur.next != tail){
                if(cur.val > cur.next.val){
                    int tmp = cur.val;
                    cur.val = cur.next.val;
                    cur.next.val = tmp;
                }
                cur = cur.next;
            }
            tail = cur;  //下一次遍历的尾结点是当前结点(仔细琢磨一下里面的道道)
            cur = node;     //遍历起始结点重置为头结点
        }
        return node;
    }
}
