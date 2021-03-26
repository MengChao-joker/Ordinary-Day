package java_0325;

public class ThreadDemo3 {
    //加锁解决 多线程修改同一数据（自加操作）
    public static void main(String[] args) throws InterruptedException {
        class count{
            public int count = 0;
            synchronized public void increase(){
                count+=2;
            }
        }
        count c = new count();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    c.increase();
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    c.increase();
                }
            }
        };
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(c.count);
    }
}
