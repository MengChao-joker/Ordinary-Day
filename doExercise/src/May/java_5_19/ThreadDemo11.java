package May.java_5_19;

import jdk.management.resource.internal.inst.ThreadRMHooks;

public class ThreadDemo11{


    public static void main(String[] args) throws InterruptedException {
        //join()方法：当前线程获取，调用join的线程的锁并进入wait直至调用join的线程状态为false
                                        //即执行完该线程的任务
        Thread thread = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
//                    Thread.yield();
//                    try {
//                        Thread.sleep(0);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.println("线程一正在运行~~");
                }
//                Thread.yield();
//                Thread.yield();
//                Thread.yield();
//                System.out.println("线程一正在运行~~");
            }

        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("线程二正在运行~~");
                }
            }
        };
        thread.start();
        thread2.start();
        thread.join();
        thread2.join();
//        System.out.println(Thread.currentThread());
//        System.out.println("thread的状态"+thread.isAlive()+" "+thread.getState());
//        thread.start();
//        thread2.start();
//        System.out.println(thread.isAlive());
//        System.out.println(System.currentTimeMillis());
//        thread.join();
//        System.out.println(System.currentTimeMillis());
//        System.out.println(thread.getPriority());
//        System.out.println(thread.isAlive());
//        thread2.join();
        System.out.println("主线程要结束了");
    }



}
