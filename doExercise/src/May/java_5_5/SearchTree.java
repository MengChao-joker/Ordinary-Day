package java_5_5;

class Node {
    int key;
    Node left;
    Node right;
    public Node(int key) {
        this.key = key;
    }
}
public class SearchTree {
    Node root = null;
    public SearchTree() {};

    public SearchTree(Node root) {
        this.root = root;
    }
    public boolean insert(int key){
        //插入操作
        Node node = new Node(key);
        if(root == null){
            this.root = node;
            return true;
        }
        Node cur = root;
        Node parent = null;
        while(cur!=null){
            if(cur.key>key){
                parent = cur;
                cur = cur.left;
            }else if(cur.key<key){
                parent = cur;
                cur = cur.right;
            }else {
                return false;
            }
        }
        if(parent.key>key){
            parent.left = node;
        }else {
            parent.right = node;
        }
        return true;
    }

    public Node find(int key) {
        //寻找操作
        if(root == null) return null;
        Node cur = root;
        while(cur!=null){
            if(cur.key>key){
                cur = cur.left;
            }else if(cur.key<key){
                cur = cur.right;
            }else {
                return cur;
            }
        }
        return null;
    }

    public boolean delete(int key){
        if(root == null) return false;
        Node cur = root;
        Node parent = null;

        while(cur!=null){
            if(cur.key>key){
                parent = cur;
                cur = cur.left;
            }else if(cur.key<key){
                parent = cur;
                cur = cur.right;
            }else {
                remove(parent,cur);
                return true;
            }
        }
        return false;
    }

    private void remove(Node parent, Node cur) {
        if (cur.left == null) {
            //1.要删除的节点没有左子树
            if (cur == root) {
                //1.1如果要删除节点为root
                root = cur.right;
            } else if (cur == parent.left) {
                //1.2 cur是parent的左子树
                parent.left = cur.right;
            } else {
                //1.3 cur是parent的右子树
                parent.right = cur.right;
            }
        } else if (cur.right == null) {
            if (cur == root) {
                root = cur.left;
            } else if (cur == parent.left) {
                parent.left = cur.left;
            } else if (cur == parent.right) {
                parent.right = cur.left;
            }
        } else {
            Node scapeGoat = cur.left;
            Node scapeGoatParent = cur;
                while (scapeGoat.right != null) {
                    scapeGoatParent = scapeGoat;
                    scapeGoat = scapeGoat.right;
                }
                cur.key = scapeGoat.key;
               if(scapeGoat == scapeGoatParent.right) {
                   scapeGoatParent.right = scapeGoat.left;
               }else {
                   scapeGoatParent.left = scapeGoat.left;
               }
        }
    }
}




