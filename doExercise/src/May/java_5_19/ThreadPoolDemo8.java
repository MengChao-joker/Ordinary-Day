package May.java_5_19;


import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo8 {
    //5.创建只有一个线程的定时器线程池
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService =
                Executors.newSingleThreadScheduledExecutor();
        System.out.println("县城开始工作~~"+new Date());
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+new Date());
            }
        }, 1, 3, TimeUnit.SECONDS);



    }
}
