package May.java_5_19;

public class ThreadDemo {
    /**
     * 死锁产生的四个必要条件
     * 1.互斥条件
     * 2.请求拥有条件（突破点）
     * 3.不可剥夺条件
     * 4.环路等待条件（突破点）
     */
    private static Object lockerA = new Object();
    private static Object lockerB = new Object();
    public static void main(String[] args) {
        //死锁出现
        new Thread(){
            @Override
            public void run() {
                synchronized (lockerA){
                    System.out.println("我得到了lockerA");
                    System.out.println("我准备获取lockerB");
                    try {
                        Thread.sleep(10);//确保死锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lockerB){
                        System.out.println("我获取到了lockerB");
                    }
                    System.out.println("thread1结束了！");
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                synchronized (lockerB){
                    System.out.println("我得到了lockerB");
                    System.out.println("我准备获取lockerA");
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lockerA){
                        System.out.println("我获取到了lockerA");
                    }
                    System.out.println("thread2结束了！");
                }
            }
        }.start();
    }


    //解决方式：
    public static void main3(String[] args) {
        //破环“不可抢占”条件
        new Thread(){
            @Override
            public void run() {
                while (true) {
                    synchronized (lockerA) {
                        System.out.println("我得到了lockerA");
                        System.out.println("我准备获取lockerB");
                        synchronized (lockerB) {
                            System.out.println("我获取到了lockerB");
                        }
                        System.out.println("thread1结束了！");
                    }
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                while (true) {
                    synchronized (lockerB){
                        System.out.println("我得到了lockerB");
                        System.out.println("我准备获取lockerA");
                        try {
                            lockerA.wait(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized (lockerA){
                            System.out.println("我获取到了lockerA");
                        }
                        System.out.println("thread2结束了！");
                    }
                }
            }
        }.start();
    }

    public static void main2(String[] args) {
        //破坏占有且等待条件
        new Thread(){
            @Override
            public void run() {
                while (true) {
                    synchronized (lockerA) {
                        System.out.println("我得到了lockerA");
                        System.out.println("我准备获取lockerB");
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized (lockerB) {
                            System.out.println("我获取到了lockerB");
                        }
                        System.out.println("thread1结束了！");
                    }
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                while (true) {
                    synchronized (lockerA){
                        System.out.println("我得到了lockerB");
                        System.out.println("我准备获取lockerA");
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized (lockerB){
                            System.out.println("我获取到了lockerA");
                        }
                        System.out.println("thread2结束了！");
                    }
                }
            }
        }.start();
    }

    public static void main1(String[] args) {
        //破坏环路等待条件：改变获取资源的时机，让其不会出现环路状态，
        // 比如1.同一时间抢夺统一资源
        //    2.给资源编号，在已拥有资源时只会去请求资源编号大于自己所拥有资源编号的资源
        new Thread(){
            @Override
            public void run() {
                while (true) {
                    synchronized (lockerA) {//1.同一时间抢夺统一资源
                        System.out.println("我得到了lockerA");
                        System.out.println("我准备获取lockerB");
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized (lockerB) {
                            System.out.println("我获取到了lockerB");
                        }
                        System.out.println("thread1结束了！");
                    }
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                while (true) {
                    synchronized (lockerA){
                        System.out.println("我得到了lockerB");
                        System.out.println("我准备获取lockerA");
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized (lockerB){
                            System.out.println("我获取到了lockerA");
                        }
                        System.out.println("thread2结束了！");
                    }
                }
            }
        }.start();
    }



}
