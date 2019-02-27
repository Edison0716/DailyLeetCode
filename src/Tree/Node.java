package Tree;

import java.util.List;

/**
 * FileName: Node
 * Author:   mac
 * Date:     2019-02-27 10:14
 * Description: Node
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
