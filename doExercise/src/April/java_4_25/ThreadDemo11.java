package java_4_25;

import java.util.Scanner;

public class ThreadDemo11 {
    //多线程加锁会出现阻塞 实例
    public static void main(String[] args) throws InterruptedException {
//加锁方式：1.加到普通方法前：相当于锁this
//         2. 加到静态方法前：i相当于给当前类的类对象加锁
//          3.加到某个代码块前：a.给实例对象（引用）加锁
//                           b.给类对象枷锁
//                           c.给实例对象的类对象加锁（synchronized(locker.getClass())）
        Object locker = new Object();//锁对象
        Thread thread = new Thread(){
            @Override
            public void run() {
                Scanner scanner = new Scanner(System.in);
                synchronized (locker) {
                    System.out.println("线程1获取到锁了~~");
                    System.out.println("请输入一个整数：");
                    int num = scanner.nextInt();
                }
            }
        };

        Thread thread1 = new Thread(()->{
            while(true){
                synchronized(locker){
                    System.out.println("线程2获取到锁了~~");
                }
            }
        });
        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
    }

    //给不同对象上锁：相当于没加（每个线程的锁是自己特有的）
    public static void main2(String[] args) throws InterruptedException {
//加锁方式：1.给实例对象（引用）加锁 2.给类对象枷锁 3.给实例对象的类对象加锁（synchronized(locker.getClass())）
        Object locker = new Object();//锁对象
        Object locker2 = new Object();
        Thread thread = new Thread(){
            @Override
            public void run() {
                Scanner scanner = new Scanner(System.in);
                synchronized (locker) {
                    System.out.println("线程1获取到锁了~~");
                    System.out.println("请输入一个整数：");
                    int num = scanner.nextInt();
                }
            }
        };

        Thread thread1 = new Thread(()->{
            while(true){
                synchronized(locker2){
                    System.out.println("线程2获取到锁了~~");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
    }


    //给同一对象的类对象上锁：与给同一对象加锁无异
    public static void main1(String[] args) throws InterruptedException {
//加锁方式：1.给实例对象（引用）加锁 2.给类对象枷锁 3.给实例对象的类对象加锁（synchronized(locker.getClass())）
        Object locker = new Object();//锁对象
        Thread thread = new Thread(){
            @Override
            public void run() {
                Scanner scanner = new Scanner(System.in);
                synchronized (locker.getClass()) {
                    System.out.println("线程1获取到锁了~~");
                    System.out.println("请输入一个整数：");
                    int num = scanner.nextInt();
                }
            }
        };

        Thread thread1 = new Thread(()->{
            while(true){
                synchronized(locker.getClass()){
                    System.out.println("线程2获取到锁了~~");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
    }
}
