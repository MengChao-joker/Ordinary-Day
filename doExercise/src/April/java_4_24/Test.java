package java_4_24;

public class Test{
//多线程

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                System.out.println("thread1正在运行~~");
            }
        };
        Thread thread2 = new Thread(()->{
            System.out.println("thread2正在运行~~");
        });
//        thread2.join();
//        thread1.join();
        thread1.start();
        thread2.start();
        while (true){}



    }

//    public static void main(String[] args) throws InterruptedException {
//        Thread.sleep(9999999);
//    }
}
