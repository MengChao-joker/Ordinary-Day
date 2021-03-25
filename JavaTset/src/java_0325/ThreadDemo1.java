package java_0325;

public class ThreadDemo1 {//线程的sleep，join，start方法
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(1000);//sleep方法：当前线程休眠指定时间
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 10; i++) {
                    System.out.println("我是新线程1");
                }
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("我是新线程2");
                }
            }
        };
        thread1.start();//start方法：让线程开始在内核态执行
        thread2.start();
        thread2.join();//join方法：保证调用者先被调度执行直至结束
        thread1.join();
        System.out.println("主线程执行完毕");

    }
}
