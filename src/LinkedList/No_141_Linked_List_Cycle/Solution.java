package LinkedList.No_141_Linked_List_Cycle;

import LinkedList.ListNode;
import java.util.ArrayList;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-05-04 10:51
 * Description:
 * Given a linked list, determine if it has a cycle in it.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *
 *
 *
 * Example 1:
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 *
 * Example 2:
 *
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 *
 * Example 3:
 *
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 *
 */

public class Solution {

    //O(1)
    public boolean hasCycle1(ListNode head){
        if (head == null) return false;
        ListNode slowP = head;
        ListNode fastP = head;

        while (fastP.next != null && fastP.next.next != null){
            slowP = slowP.next;
            fastP = fastP.next.next;
            if (slowP == fastP){
                return true;
            }
        }

        return false;
    }

    //比较low
    private ArrayList<ListNode> nodesContainer = new ArrayList<>();
    private boolean isCycle = false;
    public boolean hasCycle(ListNode head) {
        handleNode(head);
        return isCycle;
    }

    private void handleNode(ListNode head) {
        if (head == null) return;
        if (nodesContainer.contains(head)){
            isCycle = true;
            return;
        }
        nodesContainer.add(head);
        handleNode(head.next);
    }
}
