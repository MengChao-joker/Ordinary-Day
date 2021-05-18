package java_4_27;


class Singleton2 {
    private Singleton2() {

    }

    private static volatile Singleton2 instance = null;

    public static Singleton2 getInstance() {
        if (instance == null) {//一个逻辑中意义相同的判断条件会被优化到CPu寄存器：加volatile解决
            synchronized (Singleton.class) {//只有实例修改前加锁有意义，效率不高
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}

/*    public static Singleton getInstance(){
        synchronized (Singleton.class) {//只有修改前加锁有意义，效率不高
            if(instance==null){
                instance = new Singleton();
            }
        }
        return instance;
    }*/

/*    public static Singleton getInstance(){
        if(instance==null){//多线程修改同一个变量会导致线程不安全
            instance = new Singleton();
        }
        return instance;
    }*/

public class ThreadDemo23 {
    //懒汉模式

    public static void main(String[] args) {

        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println(Singleton2.getInstance());
            }
        };

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                System.out.println(Singleton2.getInstance());
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                System.out.println(Singleton2.getInstance());
            }
        };
        thread.start();
        thread1.start();
        thread2.start();

    }
}


