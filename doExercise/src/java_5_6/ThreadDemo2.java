package java_5_6;

import java.util.concurrent.locks.LockSupport;

public class ThreadDemo2 {
    /**
     * 死锁问题：a.竞争共享资源 b.进程间推进顺序非法
     * 四个必要条件：
     * 1.互斥条件
     * 2.不可剥夺条件
     * 3.请求和保持条件
     * 4.环路等待条件
     * 解决死锁的方式：破坏请求条件；破环不可剥夺条件；破坏环路等待条件；
     */
    public static void main(String[] args) {
//        LockSupport.unpark();参数指定需要唤醒的线程名
        //破坏环路等待条件
        Object locker1 = new Object();
        Object locker2 = new Object();
        int sex = 1;
        Thread thread = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    synchronized (locker1) {
                        System.out.println("我获取了locker1");
                        System.out.println("我准备获取locker2....");
                        synchronized (locker2) {
                            System.out.println("我获取了locker2");
                        }
                    }
                }
            }
        };

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    synchronized (locker2) {
                        System.out.println("我获取了locker2");
                        System.out.println("我准备获取locker1....");
                        try {
                            locker1.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("我没等带");
                        synchronized (locker1) {
                            System.out.println("我获取了locker1");
                        }
                    }
                }
            }
        };
        thread.start();
        thread2.start();

    }

    public static void main1(String[] args) {
        Object locker1 = new Object();
        Object locker2 = new Object();
        int sex = 1;
        Thread thread = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    synchronized (locker1) {
                        System.out.println("我获取了locker1");
                        System.out.println("我准备获取locker2....");
                        synchronized (locker2) {
                            System.out.println("我获取了locker2");
                        }
                    }
                }
            }
        };

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    synchronized (locker2) {
                        System.out.println("我获取了locker2");

                        System.out.println("我准备获取locker1....");
                        synchronized (locker1) {
                            System.out.println("我获取了locker1");
                        }
                    }
                }
            }
        };
        thread.start();
        thread2.start();

    }
}
