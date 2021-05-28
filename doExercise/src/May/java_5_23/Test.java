package May.java_5_23;

import java_4_24.ThreadDemo2;
import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        Object lockerA = new Object();
        Object lockerB = new Object();
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                synchronized (lockerA) {
                    try {
                        lockerA.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lockerA.notify();
                    System.out.println("A");
                }
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                synchronized (lockerA) {
                    try {
                        sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("notify前");
                    lockerA.notify();
                    try {
                        lockerA.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("notify后");
                }
            }
        };
        thread1.start();
        thread2.start();
    }
    public static void main6(String[] args) throws InterruptedException {
        for (int i = 0;i<10;i++) {
            Thread thread1 = new Thread(){
                @Override
                public void run() {
                    synchronized (Object.class) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.print("A");
                    }
                }
            };
            Thread thread2 = new Thread(){
                @Override
                public void run() {
                    System.out.print("B");
                }
            };
            Thread thread3 = new Thread(){
                @Override
                public void run() {
                    System.out.print("C");
                }
            };
            thread1.start();
            thread1.join();
            thread2.start();
            thread2.join();
            thread3.start();
            thread3.join();
            System.out.println();
        }

    }
    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("thread4");
        }
    }
    static class MyRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println("thread5");
        }
    }
    public static void main5(String[] args) {
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                System.out.println("thread1");
            }
        };
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread2");
            }
        });
        Thread thread3 = new Thread(() -> System.out.println("thread3"));
        MyThread thread4 = new MyThread();
        Thread thread5 = new Thread(new MyRunnable());
    }
    public static void main4(String[] args) {
        for (int i=0;i<20;i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("1");
                }
            });
            t.start();
            System.out.println("2");
        }
    }
    public static void main3(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(20,20,60, TimeUnit.SECONDS,new LinkedBlockingQueue<>(20),new ThreadPoolExecutor.DiscardOldestPolicy());
        for (int i = 0; i < 20; i++) {
            final int n = i;
            threadPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(n);
                }
            });
        }
        while(threadPoolExecutor.getActiveCount()>0){

        }
        System.out.println("ok");
    }
    public static void main2(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[20];
        for(int i=0; i<20; i++){
            final int n = i;
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {//内部类使用外部的变量，必须是final修饰
                    System.out.println(n);
                }
            });
        }
        for(Thread t : threads){
            t.start();
        }
        for(Thread t : threads){//同时执行20个线程，再等待所有线程执行完毕
            t.join();
        }
        System.out.println("OK");
    }
    public static void main1(String[] args) throws InterruptedException {
        for (int i = 0; i <20 ; i++) {
            int flag = i;
            Thread thread = new Thread(){
                @Override
                public void run() {
                    System.out.println(flag);
                }
            };
            thread.start();
            thread.join();
        }
        System.out.println("ok");
    }
}
