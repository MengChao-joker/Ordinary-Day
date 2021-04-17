package java_4_17;


import java.util.HashMap;

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

    public static void main(String[] args) {
        int x,y;
        x = 5>>>2;
        y = x>>>2;
        System.out.println(y);
        System.out.println(x);
    }
    //二叉搜索树不同节点间的最小差值
    //思路：中序遍历二叉搜索树，求得最小差值
    int res = Integer.MAX_VALUE;
    int pre = -1;
    public int minDisTree(TreeNode root){
        if(root==null) return 0;
        minDisTree(root.left);
        if(pre==-1){
            pre = root.val;
        }else {
            res = Math.min(res, root.val-pre);
            pre = root.val;
        }
        minDisTree(root.right);
        return res;
    }
}
