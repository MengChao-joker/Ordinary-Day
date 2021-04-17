package java_4_16;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
    protected String string= "123";
    public static int StrToInt(String str) {
        if(str==null||str.length()==0){
            return 0;
        }
        int fuhao = 0;
        int sum = 0;
        char[] chars = str.toCharArray();
        if(chars[0]=='-') fuhao = 1;
        if(47<str.charAt(0)&&str.charAt(0)<58) {
            for (int i = fuhao; i < str.length(); i++) {
                if(chars[i]=='+') continue;
                if (str.charAt(i)<48 || str.charAt(i) > 57) {
                    return 0;
                }
                sum = sum*10+(chars[i]-48);
            }
        }else {
            return 0;
        }
        return fuhao==1?sum*-1:sum;
    }

    public static void main(String[] args) {
        String s = "123456k";
        System.out.println(StrToInt(s));

    }

    public static void main2(String[] args) {
        //不为二
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int w = scanner.nextInt();
        int res = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if((i%4>1&&j%4>1)||(i%4<2&&j%4<2)){
                    res++;
                }
            }
        }
        System.out.println(res);
    }
    public static void main1(String[] args) {
//        String s = "a=1&b=1";
//        System.out.println(s.split("=")[0]);
//        System.out.println(s.split("=")[1]);
//        System.out.println(s.split("=")[2]);
         String s = "a=1";
        System.out.println(s.split("=")[1].split("&")[0]);


    }
}
