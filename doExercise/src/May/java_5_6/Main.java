package java_5_6;




//饿汉模式
class SingleTon{
    private SingleTon() {
    }
    private static final SingleTon singleTon = new SingleTon();
    public static SingleTon getInstance(){
        return singleTon;
    }
}
//懒汉模式
 class SingleTonLazy{
    private SingleTonLazy() {
    }
    private static volatile SingleTonLazy singleTonLazy = null;
    public static SingleTonLazy getInstance(){
        if(singleTonLazy==null) {
            synchronized (SingleTonLazy.class) {
                if (singleTonLazy == null) {
                    singleTonLazy = new SingleTonLazy();
                }
            }
        }
        return singleTonLazy;

    }
}
public class Main {


    public static void main(String[] args) {
        SingleTon singleTon = SingleTon.getInstance();
        SingleTonLazy singleTonLazy = SingleTonLazy.getInstance();
        System.out.println(4%5);
    }
}
