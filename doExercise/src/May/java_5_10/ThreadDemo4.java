package java_5_10;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo4 {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Thread thread = new Thread("jmc") {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "正在运行~");
                }
                lock.unlock();
            }
        };
        Thread thread1 = new Thread("wjx") {
            @Override
            public void run() {
                lock.tryLock();
//                lock.lock();
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "正在运行~");
                }
                lock.unlock();
            }
        };
        thread.start();
        thread1.start();

    }

    //可重入锁
    public static void main1(String[] args) {
        synchronized (Object.class) {//获取同一把锁
            System.out.println("第一次获取锁~");
            synchronized (Object.class) {
                System.out.println("第二次获取锁~");
            }
        }
    }
}
