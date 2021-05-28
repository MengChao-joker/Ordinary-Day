package everday_practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.math.BigInteger;
public class Day31 {
    //收件人列表
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            List<String> list = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                String name = scanner.nextLine();
                if(name.contains(",")||name.contains(" ")){
                    list.add("\""+name+"\"");
                }else {
                    list.add(name);
                }
            }

            for (int i = 0; i < n-1; i++) {
                System.out.print(list.get(i)+", ");
            }
            System.out.println(list.get(n-1));


        }
    }
    //养兔子
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = null;
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            BigInteger tem = new BigInteger("1");
            BigInteger sum = new BigInteger("1");
            for (int i = 2; i < n+1; i++) {
                BigInteger temp = tem;
                tem = sum;
                sum = sum.add(temp);
            }
            System.out.println(sum);
        }
    }

    private static int fib(int n) {
        if(n<=2) return n;
        return fib(n-1)+fib(n-2);
    }

}
