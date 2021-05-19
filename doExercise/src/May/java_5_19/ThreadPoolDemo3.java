package May.java_5_19;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class ThreadPoolDemo3 {
    /**
     * 线程池的优点
     * 1.可以避免频繁的的创建或销毁过程
     * 2.
     * 3.
     * 4.拥有更好的拒绝策略
     * 七种线程池的创建方式
     */
    //1.创建一个固定个数的线程池
    public static void main(String[] args) {
        ExecutorService executorService =
                Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            //执行任务时才会去创建线程，最多10，且不会被销毁
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
    }

}
