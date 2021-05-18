package java_5_2;

import java.util.Scanner;

public class Main {
    static class Node {
        private char val;
        private Node left;
        private Node right;

        public Node(char val) {
            this.val = val;
        }
    }
    // 二叉树的构建及遍历
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            Node root = build(s);
            inorder(root);
        }
    }
    private static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
    private static int index = 0;
    private static Node build(String s) {
        //if (index == s.length()) return null; //没必要，字符串遍历完刚好递归结束
        char cur = s.charAt(index);
        Node root = new Node(cur);
        if (cur == '#') return null;
        index++;
        root.left = build(s);
        index++;
        root.right = build(s);
        return root;
    }







}
