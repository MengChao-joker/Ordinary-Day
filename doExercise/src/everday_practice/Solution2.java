package everday_practice;

import java.util.*;

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



//    给定一个仅由小写字母组成且长度不超过106的字符串，
//    将首字符移到末尾并记录所得的字符串，不断重复该操作，
//    虽然记录了无限个字符串，但其中不同字符串的数目却是有限的，
//    那么一共记录了多少个不同的字符串？
//    输入描述:
//    输入给定的字符串。
//    输出描述:
//    输出记录的不同字符串的数目。
//    示例1
//            输入
//    abab
//            输出
//      2
//    说明
//    记录了abab和baba这2个不同的字符串。


    /**
     * 1.根据输入字符串长度判断需要循环次数
     * 2.用一个set集合来存储每次不同的字符串
     * 3.输出set集合的大小
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> set = null;
        while(scanner.hasNext()){
            String in = scanner.nextLine();
            set = new HashSet<>();
            int len = in.length()-1;
//            int pos = in.length();
            while((len--)>=0){
                in = in.substring(1,in.length())+in.charAt(0);
                set.add(in);
            }
            System.out.println(set.size());
        }
    }

    private static void swap(char[] chars, int i, int i1) {
        char temp = chars[i];
        chars[i] = chars[i1];
        chars[i1] = temp;
    }


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