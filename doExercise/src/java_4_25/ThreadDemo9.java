package java_4_25;

public class ThreadDemo9 {
    public static void main(String[] args) throws InterruptedException {
        //join()方法：让当前线程先执行完毕，再执行下文
        Thread thread = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("我是线程1");
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("我是线程2");
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
//        thread.start();//串行
//        thread.join();
//        thread2.start();
        thread.start();//并行
        thread2.start();
        thread.join();
        thread2.join();

    }
}
