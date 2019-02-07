package LinkedList.No_445_AddTwoNumbersII;

import LinkedList.ListNode;

import java.util.Stack;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-02-07 12:33
 * Description: Add Two Numbers II
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 * <p>
 * Example:
 * <p>
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 */

public class Solution {

    //栈方法
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        //总栈
        Stack<Integer> stack3 = new Stack<>();

        //链表转栈
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        //进位标记
        int c = 0;

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int sum = stack1.pop() + stack2.pop() + c;
            c = sum / 10; //算进位
            sum = sum % 10;//算各个位置的数
            stack3.push(sum);
        }

        if (!stack2.isEmpty())
            stack1 = stack2;

        while (!stack1.isEmpty()){
            int sum = stack1.pop() + c;
            c = sum / 10; //算进位
            sum = sum % 10;//算各个位置的数
            stack3.push(sum);
        }

        if (c == 1) //最高为如果还有一个进位则添加一个进位
            stack3.push(1);

        ListNode dummy = new ListNode(0);
        ListNode resultNode = dummy;

        //栈转链表
        while (!stack3.isEmpty()){
            dummy.next = new ListNode(stack3.pop());
            dummy = dummy.next;
        }

        return resultNode.next;
    }

}
