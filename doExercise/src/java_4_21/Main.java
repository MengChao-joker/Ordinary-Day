package java_4_21;

public class Main {
    class A{
        A(int a){
            System.out.println("我是父类！");
        }
        public void test(){
            System.out.println("test");
        }
    }
    class B extends A{

        B(int a) {//父类重写了构造方法为有参的构造方法，就得显式帮父类构造
            super(a);
            System.out.println("我是子类！");
        }
    }
    public void test1(){
        A a = new A(2);
        B b = (B)a;
        a = b;
        b.test();

    }
    public static void test(){
        System.out.println("test!");
    }

    public static void main(String[] args) {
        int a = 1;
        float f = 2.0000101f;
        a=(int)f;
        f = a;
        double d = 2.0000101;
        System.out.println(f);
        System.out.println(d);

        Main m = new Main();
        m.test1();
    }

    public static void main3(String[] args) {
        String str1 = "qwer0";
        String str2 = str1;
        str2 = "asdf";
        System.out.println(str1);
        System.out.println(str2);
    }
    public static void main2(String[] args) {
        ((Main)null).test();

    }
    public static void main1(String[] args) {
        String str  = "asdf";
        System.out.println(str.toUpperCase());
        System.out.println(str);

    }
}
