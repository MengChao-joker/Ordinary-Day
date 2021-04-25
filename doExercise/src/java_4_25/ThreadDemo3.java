package java_4_25;

public class ThreadDemo3{

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread("mby"){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);//进入Time_Waiting状态
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("线程要退出了！");
            }
        };
        //线程的属性：name id priority Daemon（是否是后台线程） state interrupt alive
        System.out.println(thread.getName());
        System.out.println(thread.getId());
        System.out.println(thread.getPriority());
        System.out.println(thread.isDaemon());
        System.out.println(thread.getState());
        System.out.println(thread.isInterrupted());
        System.out.println(thread.isAlive());
        thread.start();
        while(thread.isAlive()) {
            System.out.println("mby线程正在运行！");
            System.out.println(thread.getState());
            System.out.println(thread.isInterrupted());
            Thread.sleep(200);
        }
    }
}
