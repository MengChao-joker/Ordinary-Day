package May.java_5_19;

public class ThreadDemo2 {
    private static final Object locker = new Object();


    public static void main(String[] args) {
        Thread thread = new Thread("jmc"){
            @Override
            public void run() {
                while (true){
                    synchronized (locker) {
                        locker.notify();//唤醒wix线程
                        System.out.println(Thread.currentThread().getName()+"线程正在运行~~");
                        System.out.println(Thread.currentThread().getName()+"等待~~");
                        try {
                            locker.wait();//Object的方法
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    /*System.out.println(Thread.currentThread().getName()+"等待2s");
                    try {
                        Thread.sleep(2000);//属于Thread类的方法
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                }
            }
        };

        Thread thread2 = new Thread("wjx"){
            @Override
            public void run() {
                while (true){
                    synchronized (locker) {
                        locker.notify();//唤醒jmc线程
                        System.out.println(Thread.currentThread().getName()+"线程正在运行~~");
                        System.out.println(Thread.currentThread().getName()+"等待~~");
                        try {
                            locker.wait();//Object的方法
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    /*System.out.println(Thread.currentThread().getName()+"等待2s");
                    try {
                        Thread.sleep(2000);//属于Thread类的方法
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                }
            }
        };
        thread.start();
        thread2.start();
    }
}
