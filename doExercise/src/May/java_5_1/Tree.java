package java_5_1;


import java.util.ArrayList;
import java.util.Stack;

class Node {
    char val;
    Node left;
    Node right;

    public Node(char val) {
        this.val = val;
    }

}

class CreateTree {
    Node root = null;

    public CreateTree() {
        root = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');
        root.left = B;
        root.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;
    }

    //递归思路
    //前序遍历：
    public void preTraversal(Node root) {
        if (root == null) return;
        System.out.print(root.val + "->");
        preTraversal(root.left);
        preTraversal(root.right);
    }

    //中序遍历
    public void midTraversal(Node root) {
        if (root == null) return;
        midTraversal(root.left);
        System.out.print(root.val + "->");
        midTraversal(root.right);
    }

    //后序遍历
    public void lastTraversal(Node root) {
        if (root == null) return;
        lastTraversal(root.left);
        lastTraversal(root.right);
        System.out.print(root.val + "->");
    }


    //非递归遍历:利用栈先进后出的特点实现
    //前序遍历
    public void preTraversal1(Node root) {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            //根据根右左的顺序依次入栈
            Node cur = stack.pop();
            System.out.print(cur.val + "->");
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
        }
    }
    //中序遍历
    public void midTraversal1(Node root) {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.isEmpty()) {
            //常规思路从下至上左根右进行遍历
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.isEmpty()) {
                Node temp = stack.pop();
                System.out.print(temp.val + "->");
                cur = temp.right;
            }
        }
    }
    //后序遍历
    public void lastTraversal1(Node root) {
        Stack<Node> stack = new Stack<>();
        Node prev = null;
        Node cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            Node temp = stack.pop();
            if (temp.right == null || temp.right == prev) {
                System.out.print(temp.val+"->");
                prev = temp;
            } else {
                cur = temp.right;
                stack.push(temp);
            }
        }
    }
    private int ret = 0;
    //求节点个数
    public int getNode(Node root) {
        if(root == null) return ret;
        ret++;
        getNode(root.left);
        getNode(root.right);
        return ret;
    }
    //求叶子节点个数
    public int getLeafNode(Node root) {
        if(root == null) return 0;
        if(root.left==null&&root.right==null){
            return 1;
        }
        return getLeafNode(root.left)+getLeafNode(root.right);
    }

    //求第k层节点个数
    public int getKNode(Node root,int k) {
        if(root==null) return 0;
        if(k==1) return 1;
        return getKNode(root.left,k-1)+getKNode(root.right,k-1);
    }
}

public class Tree {

    public static void main(String[] args) {
        CreateTree tree = new CreateTree();
        /*System.out.println("《递归思路》");
        System.out.print("前序遍历:");
        tree.preTraversal(tree.root);
        System.out.println();
        System.out.print("中序遍历:");
        tree.midTraversal(tree.root);
        System.out.println();
        System.out.print("后序遍历:");
        tree.lastTraversal(tree.root);
        System.out.println();
        System.out.println("《非递归思路》");
        System.out.print("前序遍历:");
        tree.preTraversal1(tree.root);
        System.out.println();
        System.out.print("中序遍历:");
        tree.midTraversal1(tree.root);
        System.out.println();
        System.out.print("后序遍历:");
        tree.lastTraversal1(tree.root);*/
        System.out.print("叶子节点个数:");
        System.out.println(tree.getLeafNode(tree.root));
        System.out.print("节点个数:");
        System.out.println(tree.getNode(tree.root));
        System.out.print("第K层节点个数:");
        for (int i = 1; i < 5; i++) {
            System.out.printf("第%d层:",i);
            System.out.println(tree.getKNode(tree.root,i));
        }
    }


}
