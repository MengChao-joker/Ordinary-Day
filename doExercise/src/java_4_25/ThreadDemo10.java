package java_4_25;

public class ThreadDemo10 {
    public static int count = 0;
    public static class Counter{
        synchronized public void count(){//加锁
            count++;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        //线程安全：多个线程同时执行，运行结果不会有逻辑上的错误~
        //线程不安全：多个线程同时执行，运行结果出现逻辑上的错误~

        //多线程自增操作会导致线程不安全：
        // 1.自增操作非原子性的
        // 2.操作系统的抢占式调度
        // 3.多线程尝试修改同一个变量
        // 4.内存可见性
        // 5.指令重排序（编译器的优化）

        //解决：加锁  注意：此自加操作多线程加锁达到线程安全 会耗费更多的资源（不及单线程穿行效率高！！）
        Counter counter = new Counter();
        Thread thread = new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                counter.count();
            }
        });
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                for (int i = 0;i < 50000;i++) {
                    counter.count();
                }
            }
        };
        long beg = System.currentTimeMillis();
        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
        System.out.println(count);
        long end = System.currentTimeMillis();
        System.out.println(end-beg);
    }


    public static void main1(String[] args) {
        Counter counter = new Counter();
        long beg = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {

            counter.count();
        }
        System.out.println(count);
        long end = System.currentTimeMillis();
        System.out.println(end - beg);

    }
}
