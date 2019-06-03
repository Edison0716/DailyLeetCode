package Tree.medium.No_116_Populating_Next_Right_Pointers_in_Each_Node;

/**
 * FileName: Node
 * Author:   EdisonLi的Windows
 * Date:     2019/6/3 13:42
 * Description:
 * Difficulty:
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
