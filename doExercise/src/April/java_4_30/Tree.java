package java_4_30;

/*二叉树的创建：
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//创建节点类
class Node {
    public char val;
    public Node left;
    public Node right;

    public Node(char val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
    //    public int getVal() {
//        return val;
//    }
//
//    public void setVal(int val) {
//        this.val = val;
//    }
//
//    public Node getLeft() {
//        return left;
//    }
//
//    public void setLeft(Node left) {
//        this.left = left;
//    }
//
//    public Node getRight() {
//        return right;
//    }
//
//    public void setRight(Node right) {
//        this.right = right;
//    }
}

class TreeSet {
    Node A = new Node('A');

    public TreeSet() {
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        this.A.left = B;
        this.A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
    }

    //前序遍历
    public void preOrderTraversal(Node root) {
        if (root == null) return;
        System.out.print(root.val + "->");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    //中序遍历
    public void midOrderTraversal(Node root) {
        if (root == null) return;
        midOrderTraversal(root.left);
        System.out.print(root.val + "->");
        midOrderTraversal(root.right);
    }

    //前序遍历
    public void lastOrderTraversal(Node root) {
        if (root == null) return;
        lastOrderTraversal(root.left);
        lastOrderTraversal(root.right);
        System.out.print(root.val + "->");
    }

    //层序遍历
    public void floorTraversal(Node head) {
        Queue<Node> queue = new LinkedList<>();
        if (head != null) {
            queue.offer(head);
            while (!queue.isEmpty()) {
                Node curHead = queue.poll();
                if (curHead.left != null) {
                    queue.offer(curHead.left);
                }
                if (curHead.right != null) {
                    queue.offer(curHead.right);
                }
                System.out.print(curHead.val + "->");
            }
        }
    }

    //叶子节点个数：遍历二叉树，左右子节点都会null的为叶子节点
    public int getLeafSize(Node head) {
        if (head == null) return 0;
        if (head.left == null && head.right == null) return 1;
        return getLeafSize(head.left) + getLeafSize(head.right);
    }

    //求节点个数
    public int getNodeSize(Node head) {
        if (head == null) return 0;
        return 1 + getNodeSize(head.left) + getNodeSize(head.right);
    }

    /*第k层节点数
        如果k<1或root为空时 返回0
        k==1 返回1
        否则return getNode(head.left,k-1)+getNode(head.right,k-1);
    */
    public int getKNode(Node head, int k) {
        if (head == null) return 0;
        if (k == 1) return 1;
        return getKNode(head.left, k - 1) + getKNode(head.right, k - 1);

    }

    public int getKNode1(Node head, int k) {
        //保存每层的结果
        List<List<Node>> list = new ArrayList<>();
        List<Node> root = new ArrayList<>();
        root.add(head);
        list.add(root);
        for (int i = 1; i < k; i++) {
            List<Node> cur = new ArrayList<>();
            List<Node> tem = list.get(i - 1);
            for (int j = 0; j < tem.size(); j++) {
                //根据上一层取得本层的节点数
                Node right = tem.get(j).right;
                Node left = tem.get(j).left;
                if (left != null) {
                    cur.add(left);
                }
                if (right != null) {
                    cur.add(right);
                }
            }
            list.add(cur);
        }
        return list.get(k - 1).size();
    }

    public boolean contains(Node root, char val) {
        if (root == null) return false;
        if (root.val == val) return true;
        return contains(root.right, val) || contains(root.left, val);
    }

    private Node ret = null;

    public Node getNode(Node root, char val) {
        if (root == null) return null;
        if (root.val == val) return root;
        if (ret == null) {
            ret = getNode(root.left, val);
            ret = getNode(root.right, val);
        }
        return ret;
    }

}


public class Tree {
    public static void main(String[] args) {
        TreeSet tree = new TreeSet();
        System.out.print("前序遍历：");
        tree.preOrderTraversal(tree.A);
        System.out.println();
        System.out.print("中序遍历：");
        tree.midOrderTraversal(tree.A);
        System.out.println();

        System.out.print("后序遍历：");
        tree.lastOrderTraversal(tree.A);
        System.out.println();
        System.out.print("层序遍历：");
        tree.floorTraversal(tree.A);
        System.out.println();
        System.out.print("叶子节点个数：");
        System.out.println(tree.getLeafSize(tree.A));
        System.out.print("节点个数：");
        System.out.println(tree.getNodeSize(tree.A));
        System.out.print("第k层节点个数：");
        for (int i = 1; i < 5; i++) {
            System.out.printf("第%d层:",i);
            System.out.println(tree.getKNode1(tree.A, i));
        }
        System.out.print("是否存在节点'E':");
        System.out.println(tree.contains(tree.A, 'E'));
        System.out.print("节点'E':");
        System.out.println(tree.getNode(tree.A, 'E'));
//        for (int i = 1; i < 5; i++) {
//            System.out.println(tree.getKNode1(tree.A,i));
//        }
//
//        System.out.println(tree.contains(tree.A,'p'));


    }


}
