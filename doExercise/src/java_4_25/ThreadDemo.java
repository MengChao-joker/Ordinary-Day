package java_4_25;

public class ThreadDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            System.out.println("我是一个新线程！");
        });
        //只是调用了Thread中的run()方法
        thread.run();
        //启动线程，在操作系统中运行
        thread.start();
    }

}
