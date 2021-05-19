package May.java_5_19;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo10 {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(10, 20, 3, TimeUnit.SECONDS, new PriorityBlockingQueue<>());
        System.out.println(threadPoolExecutor.getPoolSize());
        System.out.println(threadPoolExecutor.getActiveCount());
        for (int i = 0; i < 25; i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName());
                    System.out.println("线程池大小："+threadPoolExecutor.getPoolSize());
                    System.out.println("活跃线程数："+threadPoolExecutor.getActiveCount());
                }
            });
        }


    }
}
