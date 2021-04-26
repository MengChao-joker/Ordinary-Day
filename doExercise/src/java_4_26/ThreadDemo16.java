package java_4_26;

public class ThreadDemo16 {

    //懒汉模式:需要用到实例的时候再进行new对象操作

    //多线程情下线程不安全：1.多个线程修改同一个变量（加锁）
    //                  2.效率低下（双重判断保证效率）
    //                  3.内存可见性（volatile关键字）

    //运行结果：不为同一个实例
//    java_4_26.ThreadDemo16$Singleton@3ca00ad1
//    java_4_26.ThreadDemo16$Singleton@451cdab3

//    java_4_26.ThreadDemo16$Singleton@451cdab3

    public static class Singleton {
        private Singleton() {
        }


        public static Singleton singleton = null;

        public static Singleton getSingleton() {
            if (singleton == null) {
                singleton = new Singleton();
            }
            return singleton;
        }
    }

    public static void main(String[] args) {

        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println(Singleton.getSingleton());
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                System.out.println(Singleton.getSingleton());
            }
        };
        Thread thread3 = new Thread() {
            @Override
            public void run() {
                System.out.println(Singleton.getSingleton());
            }
        };
        thread.start();
        thread2.start();
        thread3.start();
//        Singleton singleton = Singleton.getSingleton();
//        Singleton singleton1 = Singleton.getSingleton();
//        System.out.println(singleton==singleton1);//true(单线程情况)

    }
}
