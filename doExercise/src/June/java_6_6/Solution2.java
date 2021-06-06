package June.java_6_6;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
public class Solution2 {
    //广度优先DFS
    public int maxDepth1(Node root) {
        if(root==null) return 0;//判空
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        int depth = 0;
        while(!stack.isEmpty()){
            depth++;//每层只要有节点就加一
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                Node cur = stack.pop();
                for (Node child:cur.children){
                    if(child!=null) {
                        stack.push(child);
                    }
                }
            }
        }
        return depth;

    }
    //深度优先DFS
    public int maxDepth(Node root) {
        if(root==null) return 0;//判空
        if(root.children.isEmpty()){
            return 1;//终止条件
        }
        List<Integer> highest = new ArrayList<>();
        for(Node cur:root.children){
            highest.add(maxDepth(cur));
        }
        return Collections.max(highest)+1;
    }
}
