package java_5_10;

public class ThreadDemo2 {

    class Book{};
    class pen{};
    public static void main(String[] args) {
        //死锁
        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (Book.class){
                    System.out.println("线程一有纸张！想要笔");
                    synchronized (pen.class){
                        System.out.println("线程一获取到纸了");
                    }
                }
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                synchronized (pen.class){
                    System.out.println("线程二有笔！想要纸");
                    synchronized (Book.class){
                        System.out.println("线程二获取到笔了");
                    }
                }
            }
        };
        thread.start();

        thread2.start();
    }
}
