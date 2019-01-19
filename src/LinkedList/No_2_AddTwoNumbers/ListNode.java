package LinkedList.No_2_AddTwoNumbers;


/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-01-19 17:30
 * Description: Definition for singly-linked list.
 */

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public void setNext(ListNode node){
        this.next = node;
    }

    @Override
    public String toString(){
        return String.valueOf(val);
    }

}

