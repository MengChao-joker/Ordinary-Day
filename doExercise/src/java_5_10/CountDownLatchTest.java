package java_5_10;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {


    public static void main(String[] args) throws InterruptedException {
        //使用场景：多个Thread 执行完再做某一个任务
        CountDownLatch latch = new CountDownLatch(20);
        for (int i = 0; i < 20; i++) {
            new Thread(){
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    latch.countDown();
                }
            }.start();
        }
        latch.await();
        System.out.println("main");
    }
}
