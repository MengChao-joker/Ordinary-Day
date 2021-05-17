package java_5_17;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
//    public static void main2(String[] args) {
//        String s = "asa";
//        String s1 = "ascasc";
//        s1 += "asa";
//        System.out.println(s + s1);
//        System.out.println(fib(10000));
//    }


    /*public static void main(String[] args) {
        //星际密码
        int[] fib = new int[10001];
        fib[1] = 1;
        fib[2] = 2;
        for (int i = 3; i < 10001; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
            fib[i] = fib[i]%10000;
        }
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        StringBuilder code = new StringBuilder();
        while (scanner.hasNext()) {
            count = scanner.nextInt();
            int[] arrays = new int[count];
            for (int i = 0; i < count; i++) {
                arrays[i] = scanner.nextInt();
            }

            for (int i = 0; i < count; i++) {
                System.out.printf("%04d",fib[arrays[i]]);
            }
            System.out.println();
//            for (int i = 0; i < count; i++) {
//                int ret = fib[arrays[i]];
//                if (ret > 999) {
//                    code.append(ret%10000);
//                } else if (ret > 99) {
//                    code.append("0").append(ret);
//                } else if (ret > 9) {
//                    code.append("00").append(ret);
//                } else {
//                    code.append("000").append(ret);
//                }
//            }
//            System.out.println(code.toString());
        }


    }

//    private static int fib(int array) {
//        if (array == 1) {
//            return 1;
//        }
//        if (array == 2) return 2;
//        return fib(array - 2) + fib(array - 1);
//    }*/

    public static void main(String[] args) {
        //树根
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String ip = scanner.nextLine();
            int num = 0;
            for (int i = 0; i < ip.length(); i++) {
                num += ip.charAt(i) - '0';
            }
            int op = 0;
            while (true) {
                while (num != 0) {
                    op += num % 10;
                    num = num / 10;
                }
                if (op < 10) {
                    break;
                } else {
                    num = op;
                    op = 0;
                }
            }
            System.out.println(op);
        }

    }
}
