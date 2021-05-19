package May.java_5_19;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo4 {
    static class OOM {
        public byte[] _1MB = new byte[2 * 1024 * 1024];
    }

    //2.创建一个带有缓冲区的线程池
    public static void main(String[] args) {
        ExecutorService executorService =
                Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            //会带有缓冲区，即不会一直去创建线程，提高线程的利用率
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    OOM oom = new OOM();
                }
            });
        }


    }
}
