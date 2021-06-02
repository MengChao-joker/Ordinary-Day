package everday_practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Definition for a Node.
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

class Solution2 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new LinkedList<>();
        if(root==null) return ret;
        //将根节点放入队列中
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            //当队列不为空时，依次取出队列中所有的节点，并依次插入其子节点
            //将此次循环取到所有结点的值保存入一个数组
            //将循环结束后的数组放入二维数组
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while(size--!=0){
                Node curNode = queue.poll();
                List<Node> cur = curNode.children;
                for(Node node:cur){
                    queue.offer(node);
                }
                int curVal = curNode.val;
                list.add(curVal);
            }
            ret.add(list);
        }
        return ret;
    }
}