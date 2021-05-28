package May.java_5_27;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadLocalDemo1 {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) {

//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
//                1,1,60, TimeUnit.SECONDS,new LinkedBlockingQueue<>(10)
//        );
//        threadPoolExecutor.execute(new Runnable() {
//            @Override
//            public void run() {
//                MyThread myThread = new MyThread();
//                myThread.run();
//            }
//        });
//        threadPoolExecutor.execute(new Runnable() {
//            @Override
//            public void run() {
//                MyThread myThread = new MyThread();
//                myThread.run();
//            }
//        });

        Thread thread = new Thread(){
            @Override
            public void run() {
                MyThread myThread = new MyThread();
                myThread.run();
                myThread.run();
            }
        };
//        Thread thread2 = new Thread(){
//            @Override
//            public void run() {
//                MyThread myThread = new MyThread();
//                myThread.run();
//            }
//        };
        thread.start();
//        thread2.start();




    }


    static class MyThread extends Thread{
        private static boolean flag = false;
        @Override
        public void run() {
            if(!flag){
                threadLocal.set(this.getName());
                System.out.println(this.getName()+"设置了值："+this.getName());
                flag = true;
            }
            System.out.println(this.getName()+"获取到了值："+threadLocal.get());
        }
    }
}
