package java_0325;

public class ThreadDemo6 {
    //单例模式=》常见的一种”设计模式“：1.饿汉模式 2.懒汉模式

    //饿汉模式
    static class singleDog{
        private singleDog(){
        }
        private static singleDog instance = new singleDog();
        public static singleDog getInstance(){
            return instance;
        }
    }
    public static void main(String[] args) {
        singleDog s = singleDog.getInstance();
        singleDog s1 = singleDog.getInstance();
        System.out.println(s==s1);
    }
}
