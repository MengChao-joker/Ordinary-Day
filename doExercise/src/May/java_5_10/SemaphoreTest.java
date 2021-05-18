package java_5_10;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    public static void main(String[] args) throws InterruptedException {
        //使用场景：多个Thread 执行完再做某一个任务
        Semaphore semaphore = new Semaphore(0);
        for (int i = 0; i < 20; i++) {
            new Thread(){
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    semaphore.release();
                }
            }.start();
        }
        semaphore.acquire(20);
        System.out.println("main");

    }


    public static void main1(String[] args) {
        //只允许指定数量的线程同时并发访问
        Semaphore s  = new Semaphore(1000);//只允许1000个
        new Thread(()->{
            try {
                s.acquire();//线程数减一
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                s.release();//线程数加一
            }
        }).start();
    }
}
