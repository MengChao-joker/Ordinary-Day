package java_4_26;

public class ThreadDemo17 {
    //饿汉模式多线程应用及优化

    public static class Singleton{
        private Singleton(){}//构造方法私有

        public volatile static Singleton instance = null;//volatile保证内存可见性，
                                                            //防止线程中相同意义的读操作被优化为一次

        public static Singleton getInstance() {
            if(instance==null) {//双重判断保证实例引用不为空时，直接返回（无需加锁操作）
                synchronized (Singleton.class) {//加锁解决多个线程修改同一个变量
                    if (instance == null) {
                        instance = new Singleton();
                    }
                }
            }
            return instance;
        }
    }
    public static void main(String[] args) {

    }
}
