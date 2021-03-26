package java_0325;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class ThreadDemo5 {
    //wait方法 进入waiting状态 解决条件不满足导致的“饿死”问题 notify解除waiting 状态
    public static void main(String[] args) throws InterruptedException {
        Object locker = new Object();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                synchronized (locker){
                    System.out.println("进入等待");
                        try {
                            locker.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    System.out.println("等待结束");
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                Scanner scanner = new Scanner(System.in);
                System.out.println("请输入一个整数");
                scanner.nextInt();
                synchronized (locker){//同一对象上锁
                    System.out.println("notify 开始");
                    locker.notify();
                    System.out.println("notify 结束");
                }
            }
        };
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
