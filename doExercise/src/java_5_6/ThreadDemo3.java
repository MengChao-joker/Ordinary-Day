package java_5_6;

import java.util.Random;

public class ThreadDemo3 {
    static class MyThread extends Thread{
        Random random = new Random();
        @Override
        public void run() {
            while(true){
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(random.nextInt(100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        MyThread thread3 = new MyThread();
        thread1.start();
        thread2.start();
        thread3.start();
        while (true){
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(100);
        }

    }

}
