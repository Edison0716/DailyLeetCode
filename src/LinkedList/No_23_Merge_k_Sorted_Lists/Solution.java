package LinkedList.No_23_Merge_k_Sorted_Lists;

import LinkedList.ListNode;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-05-15 19:40
 * Description:
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return handleLists(lists, 0, lists.length - 1);
    }

    private ListNode handleLists(ListNode[] lists, int start, int end) {
        //如果start == end 直接返回该链表
        if (start == end) return lists[start];

        if (start < end) {
            int middle = (start + end) / 2;
            ListNode temNode1 = handleLists(lists, start, middle);
            ListNode temNode2 = handleLists(lists, middle + 1, end);
            return merge(temNode1, temNode2);
        } else {
            return null;
        }
    }

    private ListNode merge(ListNode temNode1, ListNode temNode2) {
        //如果temNode1 为空 返回另一个不为空的
        if (temNode1 == null) return temNode2;
        if (temNode2 == null) return temNode1;

        if (temNode1.val > temNode2.val){
            temNode2.next = merge(temNode1,temNode2.next);
            return temNode2;
        }else {
            temNode1.next = merge(temNode1.next,temNode2);
            return temNode1;
        }
    }
}
