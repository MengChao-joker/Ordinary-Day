package java_5_17;


class O{
    public int val = 0;
    public O next;

    public O(int val) {
        this.val = val;
    }
}
public class ReferenceLink {

    public static void main(String[] args) {
        //引用链法:垃圾回收时没有在引用链上的将被回收（也称为可达性）
        //引用计数法：每有一个地方引用这个对象，计数加一（无法解决引用之间相互引用的问题）
        O o = new O(1);
        O o1= new O(2);
        O o2 = new O(3);
        O o3 = new O(6);
        O o4 = new O(6);
//        o.next = o1;//引用之间相互引用，计数器不适用
//        o1.next = o;
        o.next = o1;
        o1.next = o2;
        O cur = o;
        while(cur!=null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }




}
