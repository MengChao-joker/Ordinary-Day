package java_4_30;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        if(Math.abs(getHigh(root.left)-getHigh(root.right))>1) return false;
        isBalanced(root.right);
        isBalanced(root.left);
        return true;
    }

    public static int getHigh(TreeNode root){
        if(root==null) return 0;
        return Math.max(getHigh(root.left)+1,getHigh(root.right)+1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        System.out.println(getHigh(root));
    }
}
