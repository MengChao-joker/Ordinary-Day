package java_5_17;

import java.util.concurrent.atomic.AtomicInteger;

public class Test {
//    private static volatile int flag = 0;
    private static AtomicInteger flag = new AtomicInteger(0);
    //多线程设计中断标记位
    public static void main(String[] args) {
        Thread thread = new Thread("太阳"){
            @Override
            public void run() {
                while (true) {
                    while(flag.get() == 12*60*60){
                        System.out.println("日出");
                        for (int i = 0; i < 12*60*60; i++) {
                            flag.decrementAndGet();
                        }
                        System.out.println("日落");
                    }
                }
            }
        };
        Thread thread1 = new Thread("月亮"){
            @Override
            public void run() {
                while (true) {
                    while(flag.get() == 0){
                        System.out.println("月升了");
                        for (int i = 0; i < 12*60*60; i++) {
                            flag.addAndGet(1);
                        }
                        System.out.println("月落星辰");
                    }
                }
            }
        };
        thread.start();
        thread1.start();
    }
}
