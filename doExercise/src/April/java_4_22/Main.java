package java_4_22;

import java.util.Scanner;

public class Main {
    //末尾零的个数
    //输入一个正整数n，求n！末尾有几个0
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int fac = 1;
            for (int i = 1; i <= n; i++) {
                fac*=i;
            }
            String str = String.valueOf(fac);
            int len = str.length()-1;
            int res = 0;
            while(str.charAt(len)==48){
                res++;
                len--;
            }
            System.out.println(res);
        }
    }




//数字颠倒
//将字符串逆序输出
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int num =scanner.nextInt();
            StringBuilder stringBuilder = new StringBuilder();
            while(num>=10){
                int tem = num%10;
                num/=10;
                stringBuilder.append(tem);
            }
            if(num<0){
                stringBuilder.append(num%10);
                stringBuilder.append('-');
            }else{
                stringBuilder.append(num%10);
            }
            System.out.println(stringBuilder.toString());

        }
    }
}
