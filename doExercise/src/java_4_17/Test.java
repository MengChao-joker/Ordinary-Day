package java_4_17;


import java.util.HashMap;

class T {
    T(String s){
        System.out.println(s);
    }

    public static void hello() {
        System.out.println("hello");
    }
}
class Y extends T{

    Y(String s) {
        super(s);
        System.out.println(s);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class Test {
    static class Fun{
        int a = 0;  }
    public static int a = 0;

    public static void main(String[] args) throws Exception {
        if(true) throw new Exception("error");
    }
    public static void main3(String[] args) {
        Fun a = new Fun();
        Fun b= a;
        b.a = 12;
        System.out.println(a.a);


    }
    public static void main2(String[] args) {
// TODO Auto-generated method stub
        T t = null;
        t.hello();
    }


    public static void main1(String[] args) {
        int x, y;
        x = 5 >>> 2;
        y = x >>> 2;
        System.out.println(y);
        System.out.println(x);
    }

    //二叉搜索树不同节点间的最小差值
    //思路：中序遍历二叉搜索树，求得最小差值
    int res = Integer.MAX_VALUE;
    int pre = -1;

    public int minDisTree(TreeNode root) {
        if (root == null) return 0;
        minDisTree(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            res = Math.min(res, root.val - pre);
            pre = root.val;
        }
        minDisTree(root.right);
        return res;
    }
}
