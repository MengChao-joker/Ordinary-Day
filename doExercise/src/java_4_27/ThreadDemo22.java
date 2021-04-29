package java_4_27;


class Singleton{
    private Singleton() {

    }
    private static Singleton instance = new Singleton();
    public static Singleton getSingleton() {
        return instance;
    }
}
public class ThreadDemo22 {
    //单例模式：饿汉模式-》在类加载时就创建了对象实例
    public static void main(String[] args) {
        Singleton singleton = Singleton.getSingleton();
        Singleton singleton1 = Singleton.getSingleton();
        System.out.println(singleton==singleton1);
    }


    public static void main1(String[] args) {
        for (Thread.State s:Thread.State.values()
             ) {
            System.out.println(s);

        }
    }
}
