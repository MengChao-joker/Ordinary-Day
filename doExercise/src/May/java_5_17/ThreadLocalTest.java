package java_5_17;

public class ThreadLocalTest {
    //ThreadLocal:线程本地变量的应用
    private static ThreadLocal<String> tl = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(()->{
            tl.set("春天");//设置当下线程的tl
            System.out.println("我是"+tl.get());//得到当前线程的tl
        });
        Thread thread1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        tl.set("冬天");
                        System.out.println("我是"+tl.get());
                    }
                }
        );
        Thread thread2 = new Thread("夏天"){
            @Override
            public void run() {
                tl.set("夏天");
                System.out.println("我是"+tl.get());
            }
        };
        thread.start();
        thread1.start();
        thread2.start();
//        thread.join();
//        thread1.join();
//        thread2.join();
        while(Thread.activeCount()>1){//除了主线程和手动创建的线程还有其他后台的线程

        }
        tl.set("秋天");
        System.out.println("我是"+tl.get());
    }



}
