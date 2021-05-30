package May.java_5_29;

public class JMCDemo1 {
    private static int pos = 0;

    public static void main(String[] args) {
        while(pos == 0) {
            String s = "kol";
            System.out.println(s);
            pos++;
            System.gc();
        }
    }

    private static void A() {
        System.out.println("执行了方法A!");
        B();
    }

    private static void B() {
        System.out.println("执行了方法B!");
        C();
    }

    private static void C() {
        System.out.println("执行了方法C!");
    }

}
