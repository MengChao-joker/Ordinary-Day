package java_4_25;


import java.util.Arrays;
import java.util.Scanner;

interface Test{
//接口中方法没有主体
    int num = 0;
    public void fun1();
    public void fun();

}
abstract class Test2{
    //接口中方法有主体
    int num = 0;

    public void fun1() {

    }

    //public void fun();
}

public class Main {


    public static void main(String[] args) {
        //查找组成一个偶数最接近的两个素数
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int num = scanner.nextInt();
            int[] nums = new int[2];

            for (int i = 1; i <= num/2; i++) {
                if(isPrime(i)&&isPrime(num-i)) {
                    nums[0] = i;
                    nums[1] = num-i;
                }
            }

            System.out.println(Arrays.toString(nums));
        }

    }

    public static boolean isPrime(int num){
        for (int i = 2; i < num; i++) {
            if(num%i==0){
                return false;
            }
        }
        return true;
    }

    public static void main2(String[] args) {
        //二进制插入
        System.out.println(1024+(19<<2));
    }

    public static void main1(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();
    }
}
