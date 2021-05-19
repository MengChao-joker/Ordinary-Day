package May.java_5_19;

import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo5 {
    //3.具有带有定时功能的线程池
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(10);
        System.out.println("任务开始时间："+new Date());
//        scheduledExecutorService.schedule(new Runnable() {
//            //定时任务一秒之后执行
//            @Override
//            public void run() {
//                System.out.println(new Date());
//            }
//        },1, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            //设置定时时间：一秒后开始执行任务，每三秒一次，每次按线程开始时间，开始计时
            //缺陷：造成程序挂掉，一个线程启动时，另一个线程任务还没执行完，长期累积，
            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(new Date());
            }
        }, 1, 3, TimeUnit.SECONDS);

//        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
//            //设置定时时间：一秒后，每三秒执行一次，并且按每次结束时间，开始计时
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(4000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(new Date());
//            }
//        }, 1, 3, TimeUnit.SECONDS);



//        scheduledExecutorService.shutdown();
    }


}
