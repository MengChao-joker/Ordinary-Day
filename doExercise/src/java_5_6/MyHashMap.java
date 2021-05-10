package java_5_6;

public class MyHashMap {
     private static class Node {
         int key;
         int val;
         Node next;
         public Node(int key, int val) {
             this.key = key;
             this.val = val;
         }
     }
         private Node[] array = new Node[101];
         public void put(int key,int val){
             //获取当前key所对应的下标
             Node node = new Node(key,val);
             int index = getIndex(key);
             if (array[index] != null) {
                 node.next = array[index];
             }
             array[index] = node;
         }
         public Integer get(int key){
             int index = getIndex(key);
             if(array[index]==null){
                 return null;
             }else {
                 Node cur = array[index];
                 while(cur.key!=key){
                     cur = cur.next;
                     if(cur==null) return null;
                 }
                 return cur.val;
             }
         }
         private int getIndex(int key) {
             return key%array.length;
         }


}



