package LinkedList.No_725_Split_Linked_List_in_Parts;

import LinkedList.ListNode;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-06-16 10:21
 * Given a (singly) linked list with head node root, write a function to split the linked list into k consecutive linked list "parts".
 * <p>
 * The length of each part should be as equal as possible: no two parts should have a size differing by more than 1. This may lead to some parts being null.
 * <p>
 * The parts should be in order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal parts occurring later.
 * <p>
 * Return a List of ListNode's representing the linked list parts that are formed.
 * <p>
 * Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]
 * Example 1:
 * Input:
 * root = [1, 2, 3], k = 5
 * Output: [[1],[2],[3],[],[]]
 * Explanation:
 * The input and each element of the output are ListNodes, not arrays.
 * For example, the input root has root.val = 1, root.next.val = 2, \root.next.next.val = 3, and root.next.next.next = null.
 * The first element output[0] has output[0].val = 1, output[0].next = null.
 * The last element output[4] is null, but it's string representation as a ListNode is [].
 * Example 2:
 * Input:
 * root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
 * Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 * Explanation:
 * The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.
 */

public class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        //划分区域
        ListNode[] listNodes = new ListNode[k];
        //找到一个链表的深度
        int depth = 0;
        for (ListNode node = root; node != null; node = node.next) {
            depth++;
        }
        int arraySize = depth / k; //一组平局有多少个元素
        int arrayLeft = depth % k;
        ListNode node = root, prev = null;
        for (int i = 0; node != null && i < k; i++, arrayLeft--) {
            listNodes[i] = node;
            for (int j = 0; j < arraySize + (arrayLeft > 0 ? 1 : 0); j++) {
                prev = node;
                node = node.next;
            }
            prev.next = null;
        }

        return listNodes;
    }
}
