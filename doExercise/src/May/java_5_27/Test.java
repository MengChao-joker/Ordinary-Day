package May.java_5_27;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.*;

public class Test {
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal(){
        @Override
        protected Integer initialValue() {
            int num = new Random().nextInt(10);
            System.out.println(Thread.currentThread().getName()+"初始化的值为："+num);
            return num;
        }
    };


    private static int id = 1;
    public static void main(String[] args) {
      ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,1,0,TimeUnit.SECONDS,
              new LinkedBlockingDeque<>(10),
              new ThreadFactory(){
                  @Override
                  public Thread newThread(Runnable r) {
                      Thread thread = new Thread(r,"thread"+id++);
                      return thread;
                  }
              }, new ThreadPoolExecutor.DiscardOldestPolicy());

      threadPoolExecutor.submit(new Runnable() {
          @Override
          public void run() {
              System.out.println(Thread.currentThread().getName()+"获取的值："+
                      threadLocal.get());

          }
      });
        threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"获取的值："+
                        threadLocal.get());


            }
        });
    }

}
