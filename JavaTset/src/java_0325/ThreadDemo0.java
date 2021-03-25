package java_0325;

class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("我是一个新线程3");
    }
}
class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("我是一个新县城4");
    }
}
public class ThreadDemo0 {
    //创建线程的方法
    //1 匿名内部类
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(){
            @Override
            public void run() {
                System.out.println("我是一个新线程1");
            }
        };
        //2
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("我是一个新线程2");
            }
        };
        Thread t2 = new Thread(runnable);
        //3
        MyThread t3 = new MyThread();
        //4
        Thread t4 = new Thread(new MyRunnable());
        //5 lambda表达式
        Thread t5 = new Thread(() -> {
            System.out.println("我是一个新线程5");
        });
        t1.start();
        Thread.sleep(1000);
        t2.start();
        Thread.sleep(1000);
        t3.start();
        Thread.sleep(1000);
        t4.start();
        Thread.sleep(1000);
        t5.start();
    }


}
