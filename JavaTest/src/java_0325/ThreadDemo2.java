package java_0325;

public class ThreadDemo2 {//线程的中断
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    //Thread.currentThread().isInterrupted():当前线程是否被中断（仅获取状态）
                    System.out.println(Thread.currentThread().isInterrupted());
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    //Thread.interrupted():获取当前线程是否中断（随即将状态修改为false）
                    System.out.println(Thread.interrupted());
                }
            }
        };
//        t.start();
//        t.interrupt();
//        Thread.sleep(1000);
        t2.start();
        t2.interrupt();
    }
}
