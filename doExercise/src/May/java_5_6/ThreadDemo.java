package java_5_6;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.concurrent.locks.LockSupport;

public class ThreadDemo {

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("我是线程二~");
        }
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("我是线程四~");
        }
    }

    public static void main(String[] args) {
        //线程的创建方式
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                System.out.println("我是线程一~");
                System.out.println(Thread.currentThread().getState());
                LockSupport.park();
                System.out.println(Thread.currentThread().getState());
            }
        };
        thread1.start();
        System.out.println(thread1.getState());


//        System.out.println(thread1.getState());
//        System.out.println(Arrays.toString(Thread.State.values()));
//        Thread thread2 = new MyThread();
//        Thread thread3 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("我是线程三~");
//            }
//        });
//        MyRunnable runnable = new MyRunnable();
//        Thread thread4 = new Thread(runnable);
//
//        Thread thread5 = new Thread(() -> {
//            System.out.println("我是线程五~");
//        });
//        thread2.start();
//        thread3.start();
//        thread4.start();
//        thread5.start();


    }


}
