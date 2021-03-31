package java_0325;

import java.util.Collection;
import java.util.Scanner;
public class ThreadDemo4 {
    //volatile 关键字 解决内存可见性 导致的 不安全问题
    static class Counter{
        volatile public int flag = 0;
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                while(counter.flag==0){

                }
                System.out.println("循环结束");
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                Scanner s = new Scanner(System.in);
                System.out.println("请输入一个整数");
                counter.flag=s.nextInt();
            }
        };
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
