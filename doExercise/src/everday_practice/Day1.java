package everday_practice;

import java.util.Scanner;

public class Day1 {
    public static void main1(String[] args) {
        //星际密码
        int[] fib = new int[10001];
        fib[1] = 1;
        fib[2] = 2;
        for (int i = 3; i < 10001; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
            fib[i] = fib[i] % 10000;
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
                System.out.printf("%04d", fib[arrays[i]]);
            }
            System.out.println();
        }
    }


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

