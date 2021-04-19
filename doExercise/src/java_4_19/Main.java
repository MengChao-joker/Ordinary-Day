package java_4_19;

import java.util.Scanner;

public class Main {
    //最大公约数：辗转相除法
    //最小公倍数：两数之积除以最大公约数
    public static int maxGYS(int a,int b){
        if(a<b) {//保证a为两者中较大的数
            int tem = a;
            a = b;
            b = tem;
        }
        while(a%b!=0){//辗转相除
            int tem = b;
            b = a%b;
            a = tem;
        }
        return b;
    }
    //最小公倍数
    public static int minGBS(int a,int b){
        return a*b/maxGYS(a,b);
    }


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            int a  = s.nextInt();
            int b = s.nextInt();
            System.out.println(minGBS(a,b));
        }
    }


    public static void main1(String[] args) {
         Scanner scan = new Scanner(System.in);
         while(scan.hasNext()){
             int w = scan.nextInt();
             int h = scan.nextInt();
             int res = 0;
             for (int i = 0; i < h; i++) {
                 for (int j = 0; j < w; j++) {
                     if(i%4>=2&&j%4>=2||i%4<2&&j%4<2) res++;
                 }
             }
             System.out.println(res);

         }
    }
}
