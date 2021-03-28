package java_0325;

public class ThreadDemo8 {
    //懒汉模式实现线程安全的优化synchronized 双重判断 volatile
    static class singleDog{
        private singleDog(){}
        private static volatile singleDog instance = null;
        public static singleDog getInstance(){
            if(instance==null) {
                synchronized (singleDog.class) {
                    if (instance == null) {
                        instance = new singleDog();
                    }
                }
            }
            return instance;
        }
    }
    public static void main(String[] args) {

    }
}
