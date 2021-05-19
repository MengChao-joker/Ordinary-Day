package May.java_5_19;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ThreadPoolDemo6 {
    //带有线程工厂的线程池
    public static void main(String[] args) {
        ExecutorService executorService =
                Executors.newFixedThreadPool(10, new MyThreadFactory());
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    Thread thread = Thread.currentThread();
                    System.out.println(thread.getName()+" "+thread.getPriority());
                }
            });
        }

    }
    static class  MyThreadFactory implements ThreadFactory{
        private static int count = 1;
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName("pool_thread"+count++);
            thread.setPriority(6);
            return thread;
        }
    }
}
