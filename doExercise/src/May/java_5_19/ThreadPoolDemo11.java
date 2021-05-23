package May.java_5_19;

import java.util.concurrent.*;

public class ThreadPoolDemo11 {
    private static int id = 1;

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                1,1,60, TimeUnit.SECONDS,new LinkedBlockingDeque<>(10),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r,"threadPool-"+id++);
                        return thread;
                    }
                },new ThreadPoolExecutor.DiscardOldestPolicy()
        );
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
//        Thread.sleep(10);
        for (int i = 0; i < 10; i++) {
            int flag = i;
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(flag+Thread.currentThread().getName());
                }
            });
        }
        Future<Integer> future = threadPoolExecutor.submit(new Callable<Integer>(
        ) {
            @Override
            public Integer call() throws Exception {
                return null;
            }
        });
        threadPoolExecutor.shutdown();
    }
}
