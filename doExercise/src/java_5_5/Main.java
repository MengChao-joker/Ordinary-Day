package java_5_5;

public class Main {
    public static void preOrder(Node root){
        if(root == null) return;
        System.out.print(root.key+"->");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.key+"->");
        inorder(root.right);
    }

    public static void main(String[] args) {
        SearchTree searchTree = new SearchTree();
        searchTree.insert(9);
        searchTree.insert(5);
        searchTree.insert(2);
        searchTree.insert(4);
        searchTree.insert(3);
        searchTree.insert(6);
        searchTree.insert(8);
        preOrder(searchTree.root);
        System.out.println();
        inorder(searchTree.root);
    }
}
