package java_5_2;

import java_5_1.Tree;

import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

public class Solution {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    //二叉树的层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        //判空
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;
        //利用队列特性遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            /**
             *依次遍历每层的节点并放入list中
             * 在遍历过程中所在层的每个结点的左右节点依次放入队列中
             *遍历结束将list放入ret
             * 循环此过程，直至队列为空，所有节点遍历完毕
             */
            List<Integer> list = new ArrayList<>();
            //保存当前队列的大小即该层的节点个数（因为大小是动态的）
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if(cur.left!=null) queue.offer(cur.left);
                if(cur.right!=null) queue.offer(cur.right);
            }
            ret.add(list);
        }
        return ret;
    }






    //二叉树的最近公共祖先
    TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findLCA(root, p, q);
        return lca;
//        if(findLCA(root,p,q)){
//        可以不用判断，直接返回lca，不存在的话lca为null，存在即返回lca为最近公共祖先节点
//            return lca;
//        }else {
//            return null;
//        }

    }
    private boolean findLCA(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return false;
        /**
         *  最近公共祖先：一棵树的根节点以及他的左右子树存在  这两个节点p和q
         *  且不能在同一个位置（查询的两个节点不存在同一个子树中，
         *  三种情况：
         *  1.根左 2.根右 3.左右
         */

        int left = findLCA(root.left,p,q)?1:0;
        int right = findLCA(root.right,p,q)?1:0;
        int mid = (root==p||root==q)?1:0;
        if(left+right+mid==2){
            lca = root;
        }
        return left+right+mid>0;
    }






    //二叉搜索树转双向链表:最终链表：左子树的链表+根节点+右子树的链表
    public TreeNode Convert(TreeNode pRootOfTree) {
        //跟为空返回null
        if(pRootOfTree==null) return null;
        //根的左右都为空返回根
        if(pRootOfTree.right==null&&pRootOfTree.left==null) return pRootOfTree;
        TreeNode leftHead = Convert(pRootOfTree.left);
        //递归左树：找到左树的尾巴节点与根节点相连
        TreeNode leftTail = leftHead;
        while(leftTail!=null&&leftTail.right!=null){
            //找到尾巴节点
            leftTail = leftTail.right;
        }
        if(leftTail!=null) {
            //与根节点相连
            leftTail.right = pRootOfTree;
            pRootOfTree.left = leftTail;
        }
        TreeNode rightHead = Convert(pRootOfTree.right);
        //右树的头节点
        if(rightHead!=null){
            //有数的头结点与根节点相连
            pRootOfTree.right = rightHead;
            rightHead.left = pRootOfTree;
        }
        //左树为空以根节点作为头节点 否则以左树的头节点作为链表的头节点
        if(leftHead==null) {
            return pRootOfTree;
        }else {
            return leftHead;
        }
    }



    //从前序与中序遍历序列构造二叉树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildChildTree(preorder,inorder,0,inorder.length-1);

    }
    int preIndex = 0;
    public TreeNode buildChildTree(int[] preorder,int[] inorder,int inbegin,int inend) {
        //inbegin>inend时 返回null
        if(inbegin>inend) return null;
        TreeNode root = new TreeNode(preorder[preIndex]);
        preIndex++;//前序遍历数组下标
        //在中序遍历数组中找到当下的root节点下表
        int index = findIndex(preorder[preIndex],inorder,inbegin,inend);
        //向左递归
        root.left = buildChildTree(preorder,inorder,inbegin,index-1);
        //向右递归
        root.right = buildChildTree(preorder,inorder,index+1,inend);
        return root;
    }
    public int findIndex(int i, int[] inorder, int inbegin, int inend) {
        while(inorder[inbegin]!=i){
            inbegin++;
        }
        return inbegin;
    }



    //从中序与后序遍历序列构造二叉树
    private int postIndex = 0;
    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        postIndex = postorder.length-1;
        return buildTreeByInAndPost(inorder,postorder,0,inorder.length-1);
    }
    private TreeNode buildTreeByInAndPost(int[] inorder, int[] postorder, int i, int length) {
        if(i>length) return null;
        TreeNode root = new TreeNode(postorder[postIndex]);
        int index = findVal(postorder[postIndex],inorder,i,length);
        postIndex--;
        root.right = buildTreeByInAndPost(inorder,postorder,index+1,length);
        root.left = buildTreeByInAndPost(inorder,postorder,i,index-1);
        return root;
    }

    private int findVal(int val, int[] inorder, int inbegin, int length) {
        while(inorder[inbegin]!=val){
            inbegin++;
        }
        return inbegin;
    }



    //根据二叉树创建字符串
    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        if(t==null) return "";
        sb.append("(");
        sb.append(t.val);
        if(t.left==null){
            if(t.right==null){
                return sb.toString();
            }else{
                sb.append("()");
            }
        }else{
            sb.append('(');
            tree2str(t.left);
            sb.append(')');
        }
        if(t.right!=null){
            sb.append('(');
            tree2str(t.right);
            sb.append(')');
        }else {
            return sb.toString();
        }
        return sb.toString();
    }


}
