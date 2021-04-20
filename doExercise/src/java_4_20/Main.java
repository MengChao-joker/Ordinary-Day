package java_4_20;


import java.util.*;

class A{

}
class B extends A{

}
class C extends  B{

}
public class Main {
    static class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        String s = "asdf";
        System.out.println(s.substring(0,2));
    }

    public static void main5(String[] args) {
        Scanner s = new Scanner(System.in);
        while(s.hasNext()) {
            String s1 = s.nextLine();
            String[] str = s1.split(" ");
            int[] nums = new int[str.length-1];
            for (int i = 0; i < str.length-1; i++) {
                nums[i] =  Integer.parseInt(str[i]);
            }
            Arrays.sort(nums);
            for (int i = 0; i < Integer.parseInt(str[str.length-1]); i++) {
                System.out.print(nums[i]+" ");
            }
        }
    }

    public static void main4(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            int m = s.nextInt();
            for (int i = 0; i < m; i++) {
                queue.add(i);
            }
            int count = 0;
            while(queue.size()!=1){
                if(count!=2){
                    int tem = queue.remove();
                    queue.offer(tem);
                    count++;
                }else {
                    queue.remove();
                    count = 0;
                }

            }
            System.out.println((int)queue.peek());

        }
    }

    public static void main3(String[] args) {
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            int length = s.nextInt();
            int[] nums = new int[length];
            Node head = new Node(0);
            Node cur = head;
            for (int i = 1; i < length; i++) {
                cur.next = new Node(i);
                cur = cur.next;
            }
            cur.next = head;
            Node cur1 = head;
            while(cur1.next!=cur1){
                cur1.next.next = cur1.next.next.next;
            }
            System.out.println(cur1.val);

        }
    }

    public static void main2(String[] args) {
        A a = new A();
        A a1 = new B();
        a = new C();
    }


    public static void main1(String[] args) {
        float f = 3.0f;//小数点后八位
        double d = 3;//小数点后16位
        int a = 1;
        System.out.println(d/a);
        System.out.println(a/d);
    }
}
