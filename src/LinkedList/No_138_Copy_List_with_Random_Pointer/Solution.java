package LinkedList.No_138_Copy_List_with_Random_Pointer;


import java.util.HashMap;
import java.util.Map;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-06-08 15:25
 * Description:
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input:
 * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 *
 * Explanation:
 * Node 1's value is 1, both of its next and random pointer points to Node 2.
 * Node 2's value is 2, its next pointer points to null and its random pointer points to itself.
 */
public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        final Map<Node, Node> map = new HashMap<>();
        Node cur = head;

        while(cur != null) {
            Node node = new Node();
            node.val = cur.val;
            map.put(cur, node);
            cur = cur.next;
        }

        for (Map.Entry<Node, Node> entry : map.entrySet()) {
            //开辟一个新的地址
            final Node newNode = entry.getValue();
            newNode.next = map.get(entry.getKey().next);
            newNode.random = map.get(entry.getKey().random);
        }

        return map.get(head);
    }
}
