package May.java_5_27;

import java.util.concurrent.ThreadPoolExecutor;

public class ThreadDemo2 {
    private static int flag = 1;
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(){
            @Override
            public void run() {
                while(flag==1){

                }
                System.out.println("循环退出");
            }
        };
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                flag = 2;
            }
        };
        thread.start();
        Thread.sleep(1000);
        thread1.start();
    }
}
