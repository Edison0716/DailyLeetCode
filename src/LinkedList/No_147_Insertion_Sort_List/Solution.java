package LinkedList.No_147_Insertion_Sort_List;


import LinkedList.ListNode;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-05-27 20:21
 * Description: Insertion Sort List
 * Difficulty: Medium
 * Sort a linked list using insertion sort.
 * <p>
 * <p>
 * A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
 * With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list
 * <p>
 * <p>
 * Algorithm of Insertion Sort:
 * <p>
 * Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
 * At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
 * It repeats until no input elements remain.
 * <p>
 * Example 1:
 * <p>
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 * <p>
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        //创建一个新的头结点
        ListNode pre = new ListNode(-1);

        ListNode temSavePre = pre;

        //原来的链表指针
        ListNode cur = head;

        while (cur != null){
            //每次循环重置头结点
            pre = temSavePre;
            // pre.next.val > cur.val 循环终止
            while (pre.next != null && pre.next.val < cur.val){
                pre = pre.next;
            }
            //插入pre
            ListNode tem = cur.next;
            cur.next = pre.next;
            pre.next = cur;

            cur = tem;
        }

        return temSavePre.next;
    }


    //复习一下数组的插入排序吧
    class SolutionForArray {
        public void insertSort(int[] array) {
            int length = array.length;
            if (length <= 1) return;
            for (int i = 1; i < length; i++) {
                if (array[i - 1] > array[i]){
                    int temp = array[i];
                    int j = i;
                    while (j > 0 && array[j - 1] > temp){
                        array[j] = array[j - 1];
                        j--;
                    }
                    array[j] = temp;
                }
            }
        }
    }
}
