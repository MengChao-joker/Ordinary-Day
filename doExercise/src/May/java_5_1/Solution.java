package java_5_1;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {


    //平衡二叉树
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        //两子树高度差大于1 return false
        if(Math.abs(getHigh(root.left)-getHigh(root.right))>1) return false;

        return isBalanced(root.left)&&isBalanced(root.right);
    }
    private int high = 0;
    private int getHigh(TreeNode root){
        if(root == null) return 0;
        //最大高度
        return Math.max(getHigh(root.left)+1,getHigh(root.right)+1);
    }


    // 另一个树的子树
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //判空
        if(root == null&&subRoot == null) return true;
        if(root == null||subRoot == null) return false;
        //判断是否相同
        if(isSame(root,subRoot))return true;
        //遍历所有子树判断是否存在相同
        return isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot);
    }
    public boolean isSame(TreeNode p,TreeNode q){
        //判断是否相同
        if(p==null&&q==null) return true;
        if(p==null||q==null) return false;
        if(p.val!=q.val) return false;

        return isSame(p.left,q.left)&&isSame(p.right,q.right);
    }


    //最大深度
    public int maxDepth(TreeNode root) {
        //判空
        if(root == null) return 0;
        //取左右子树的最高值
        return Math.max(maxDepth(root.left)+1,maxDepth(root.right)+1);
    }

    //镜像二叉树
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        //判断左右子树是否为镜像
        return isMirror(root.left,root.right);

    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        //判空
        if(left==null&&right==null) return true;
        if(left==null||right==null) return false;
        //不相等直接返回false
        if(left.val!=right.val) return false;
        return isMirror(left.left,right.right)&&isMirror(left.right,right.left);
    }


    //二叉搜索树转双向链表:最终链表：左子树的链表+根节点+右子树的链表
    public TreeNode Convert(TreeNode pRootOfTree) {
        //跟为空返回null
        if(pRootOfTree==null) return null;
        //根的左右都为空返回根
        if(pRootOfTree.left==null&&pRootOfTree.right==null) return pRootOfTree;
        //处理左子树
        TreeNode leftHead = Convert(pRootOfTree.left);
        TreeNode tail = leftHead;
        while(tail!=null&&tail.right!=null){
            //左链的尾巴
            tail = tail.right;
        }
        if(tail!=null) {//最左边的时候
            tail.right = pRootOfTree;
            pRootOfTree.left = tail;
        }
        //处理右子树
        TreeNode rightHead = Convert(pRootOfTree.right);

        if(rightHead!=null){
            pRootOfTree.right = rightHead;
            rightHead.left = pRootOfTree;
        }
        //左子树为空，则返回跟节点为链表的头
        if(leftHead == null){
            return pRootOfTree;
        }else {
            return leftHead;
        }
    }


        //最近公共祖先
    TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(findLCA(root,p,q)){
            return lca;
        }else {
            return null;
        }

    }

    private boolean findLCA(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return false;
        int left = findLCA(root.left,p,q)?1:0;
        int right = findLCA(root.right,p,q)?1:0;
        int mid = (root==p||root==q)?1:0;
        if(left+right+mid==2){
            //一棵树的根左右包含了p,q（且只能同时包含一个需要查找的元素）
            lca = root;
        }
        return (left+right+mid)>0;
    }
}
