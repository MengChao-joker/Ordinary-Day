package java_4_26;

import java.util.concurrent.PriorityBlockingQueue;


abstract class Animal {
    abstract void say();

}

class cat extends Animal {
    //抽象方法必须被重写，且其在抽象类中没有主体
    @Override
    void say() {

    }
}
interface Animals {
    abstract void say();

}

public class Test {

    public float doSome(float a){
        //方法重载：参数可变，返回值可变
        return a;
    };
    private float doSome(float a,int b){
        //方法重载：参数可变，返回值可变
        return a;
    };
    public float doSome(float a,float b){
        return a;
    };
    public int doSome(int a,float b){
        return a;
    };


    //比较器:
    /*public static int compare(int x, int y) {
        return (x < y) ? -1 : ((x == y) ? 0 : 1);
    }*/
    public static void main1(String[] args) {
        PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>();
        queue.add(2);
        queue.add(6);
        System.out.println(queue.remove());
    }

    static boolean out(char c) {
        System.out.println(c);
        return true;
    }

    public static void main(String[] args) {
        int i = 0;
        for (out('a'); out('b') && i < 2; out('c')) {
            i++;
            System.out.println('d');
        }

    }
}
