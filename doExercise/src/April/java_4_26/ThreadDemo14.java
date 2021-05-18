package java_4_26;

import java.util.Scanner;

public class ThreadDemo14 {

    public static void main(String[] args) {
        Object locker = new Object();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    synchronized (locker) {
                        System.out.println("线程等待前~");
                        try {
                            locker.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("线程等待后~");
                    }
                }
            }
        });

        Thread thread1 = new Thread(){
            @Override
            public void run() {
                Scanner s = new Scanner(System.in);
                System.out.println("请输入一个整数进入Notify操作~");
                int nums = s.nextInt();
                synchronized(locker){
                    System.out.println("notify前~");
                    locker.notify();
                    System.out.println("notify后~");
//                    System.out.println("notify前~");
//                    thread.interrupt();
//                    System.out.println("notify后~");

                }
            }
        };

        thread.start();
        thread1.start();
    }
}
