package java_5_10;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //实现callable接口
        FutureTask task = new FutureTask(new Callable() {
            @Override
            public String call() throws Exception {
                int ticket = 10;
                while (ticket > 0) {
                    System.out.println("剩余票数" + ticket--);
                }
                System.out.println("休息会~");
                Thread.sleep(10000);
                return new String("票卖完了！");
            }
        });
        new Thread(task).start();
        System.out.println(task.get());//1.获取任务的返回值 2.如果任务没有执行完，当前线程阻塞等待
        System.out.println("main");


    }
}
