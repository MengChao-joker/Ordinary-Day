package May.java_5_24;

public class Test {

    public static void main(String[] args) {
        //思索的条件：互斥量；不可剥夺条件；互相持有对方资源并请求所持有对方资源；环路等待条件
        Object A = new Object();
        Object B = new Object();
        Thread pen = new Thread(){
            @Override
            public void run() {
                synchronized (A){
                    System.out.println("我有笔！");
                    System.out.println("我要获取纸~");
                    synchronized (B){
                        System.out.println("我获取到了纸！");
                    }
                }
            }
        };
        Thread paper = new Thread(){
            @Override
            public void run() {
                synchronized (B){
                    System.out.println("我有纸！");
                    System.out.println("我要获取笔~");
                    synchronized (A){
                        System.out.println("我获取到了笔！");
                    }
                }
            }
        };
    }
    public static void main1(String[] args) throws InterruptedException {
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println(System.currentTimeMillis());
                try {
                    Thread.sleep(1000);//Thread的方法
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis());
            }
        };
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                synchronized (Object.class) {
                    System.out.println("wait前");
                    try {
                        Object.class.wait();//object的方法
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("wait后");
                }
            }
        };
        thread.start();
        thread.join();
        thread1.start();
        System.out.println(thread1.getState());
        Thread.sleep(2000);
        System.out.println(thread1.getState());
    }
}
