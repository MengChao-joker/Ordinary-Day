package java_5_10;

import sun.awt.windows.ThemeReader;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadDemo3 {
    public static final AtomicInteger COUNT = new AtomicInteger();

    //    public static void add(int count){
//        do {
//            //获取预期值
//        }while(cas);//比较预期值是否与实际值相等，相等则完成交换操作
//
//    }
    public static void main(String[] args) {
        //原子性自增操作
        for (int i = 0; i < 10; i++) {
            new Thread(){
                @Override
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        COUNT.addAndGet(1);
                    }
                }
            }.start();
        }
//        while (Thread.activeCount()>1){
//            Thread.yield();
//        }
        System.out.println(COUNT);
    }


}
