package java_5_17;

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
class Solution {
    public Node treeToDoublyList(Node root) {
        Node head = root;
        while (head.left != null) {
            head = head.left;
        }
        return head;

    }
}
