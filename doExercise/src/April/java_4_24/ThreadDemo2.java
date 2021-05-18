package java_4_24;

public class ThreadDemo2 {
    //创建线程的五种方法
    public static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("我是thread3！");
        }
    }
    public static class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("我是thread5！");
        }
    }
    public static void main(String[] args) {
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                System.out.println("我是thread1！");
            }
        };
        Thread thread2 = new Thread(()->{
            System.out.println("我是thread2！");
        });
        MyThread thread3 = new MyThread();
        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是thread4！");
            }
        });
        Thread thread5 = new Thread(new MyRunnable());
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
