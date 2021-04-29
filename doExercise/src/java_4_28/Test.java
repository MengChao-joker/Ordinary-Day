package java_4_28;

public class Test {

    public static void main(String[] args) {
        String s = new String("asd");
        String s1 = new String("asd");
        System.out.println(s==s1);

    }


    public static void main2(String[] args) {
        System.out.println('a'+2+3.14);//数字与字符相加为基本数据类型
        System.out.println("a"+2+3.14);//数字与字符串相加为字符串
    }
    public static void main1(String[] args) {
        int[] n = new int[2];//运行报错java.lang.ArrayIndexOutOfBoundsException: 2
        n[2] = 0;
     }
}
