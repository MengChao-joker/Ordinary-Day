package java_4_26;

public class ThreadDemo20 {
    //线程的五种构造

    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("我是创建方式4~~");
        }
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("我是创建方式5~~");
        }
    }






    public static void main(String[] args) {
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                System.out.println("我是创建方式1~~");
            }
        };

        Thread thread2 = new Thread(()->{
            System.out.println("我是创建方法2~~");
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是创建方式3~~");
            }
        });

        MyThread thread4 = new MyThread();

        Thread thread5 = new Thread(new MyRunnable());

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();





    }
}
