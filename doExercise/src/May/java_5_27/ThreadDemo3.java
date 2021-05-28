package May.java_5_27;

import java.util.Random;

public class ThreadDemo3 {


    public static void main(String[] args) {
        PC pc =new PC(10);
        Thread producer = new Thread("producer"){
            @Override
            public void run() {
                while (true) {
                    int good = new Random().nextInt(10);
                    try {
                        System.out.println(Thread.currentThread().getName()+"生产了"+
                                good);
                        pc.produce(good);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread customer = new Thread("customer"){
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(100);
                        System.out.println(Thread.currentThread().getName()+"消费了"+
                                pc.custom());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        producer.start();
        customer.start();

    }
}
