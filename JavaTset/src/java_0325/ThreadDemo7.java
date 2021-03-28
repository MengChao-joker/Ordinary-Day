package java_0325;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class ThreadDemo7 {
    //懒汉模式 在线程中会出现线程不安全
    static class singleDog1{
        private singleDog1(){}
        private static singleDog1 instance = null;
        public static singleDog1 getInstance(){
            if(instance==null) {
                instance = new singleDog1();
            }
            return instance;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                singleDog1 s = singleDog1.getInstance();
                System.out.println(s);
            }

        };
        Thread t2 = new Thread(()->{
           singleDog1 s1 = singleDog1.getInstance();
            System.out.println(s1);
        });
        t1.start();
        t2.start();
        System.out.println("结束");
    }
}
