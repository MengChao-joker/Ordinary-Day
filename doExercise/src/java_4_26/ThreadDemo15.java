package java_4_26;

public class ThreadDemo15 {
    //设计模式：单例模式->饿汉模式  懒汉模式

    //饿汉模式:在类加载时期就直接实例化对象了
    public static class SingleTon{
        private SingleTon(){};

        private static SingleTon instance = new SingleTon();

        public static SingleTon getInstance() {
            return instance;
        }
    }

    public static void main(String[] args) {
        SingleTon singleTon = SingleTon.getInstance();
        SingleTon singleTon1 = SingleTon.getInstance();
        System.out.println(singleTon==singleTon1);//获取的时同一个实例（类加载时期创建的）

    }
}
