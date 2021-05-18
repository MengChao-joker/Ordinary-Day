package java_4_29;


import java.util.Queue;

class Node{
    public int val = 0;
    public Node next = null;

    public Node(int val) {
        this.val = val;
    }
}

public class MyQueueByLinkedList {

    private Node head = null;//头节点
    private Node tail = null;//为节点

    public void offer(int val){
        Node node = new Node(val);
        if(this.head==null) {
            this.head = node;
            this.tail = node;
        }
        tail.next = node;
        tail = tail.next;
    }

    public Integer poll(){
        if(this.head==this.tail) return null;
        int ret = head.val;
        head = head.next;
        return ret;
    }





}
