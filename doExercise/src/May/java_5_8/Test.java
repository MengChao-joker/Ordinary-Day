package java_5_8;

import java.util.Scanner;
abstract interface A{
    void fly();
        }
        class B implements A{
    //实现接口中的方法，修饰符必须是public
    public B(int a){
        System.out.println("我是有参构造器~");
    };

    public void fly(){

    };
        }
        class C extends B{

            public C(int a) {
                super(a);
            }
        }

public class Test {
    public static void main(String[] args) {
        String s = "1234567890";
        String s1 = s.substring(5);
        System.out.println(s1);

    }

    public static void main2(String[] args) {
        Integer i1 = new Integer(2);
        int i = 2;
        Integer i2 = Integer.valueOf(2);
        Integer i3 = 2;
        System.out.println(i==i1);
        System.out.println(i1==12);
        System.out.println(i2==i3);
        System.out.println(Math.pow(2, 3));


    }


    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            if(n<3){
                System.out.println(-1);
            }else if(n%2==0){
                System.out.println(3);
            }else {
                System.out.println(2);
            }
        }
        scanner.close();
    }
}
