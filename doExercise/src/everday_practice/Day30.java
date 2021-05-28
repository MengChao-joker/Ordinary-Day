package everday_practice;

import java.util.Scanner;

public class Day30 {
    /**
     * 网络号：主机IP和子网掩码进行与运算
     * A类地址：128.0.0.0 可提供2^24-2 B类：128.128.0.0  2^16-2个主机号
     */


    public static void main(String[] args) {
        /**
         * 所谓因子分解，就是把给定的正整数a，分解成若干个素数的乘积，即 a = a1 × a2 × a3 × ... × an,并且 1 < a1 ≤ a2 ≤ a3 ≤ ... ≤ an。其中a1、a2、...、an均为素数。 先给出一个整数a，请输出分解后的因子。
         * 输入描述:
         * 输入包含多组数据，每组数据包含一个正整数a（2≤a≤1000000）。
         * 输出描述:
         * 对应每组数据，以“a = a1 * a2 * a3...”的形式输出因式分解后的结果。
         * 示例1
         * 输入
         * 10<br/>18
         * 输出
         * 10 = 2 * 5<br/>18 = 2 * 3 * 3
         */
        Scanner s
                 = new Scanner(System.in);
        StringBuilder res = null;
        while (s.hasNext()){
            res = new StringBuilder();
            int num = s.nextInt();
            res.append(num).append(" = ");
            double sqrt = Math.sqrt(num);
            for (int i = 2; i < sqrt; i++) {
                while(num%i==0){
                    res.append(i+" * ");
                    num/=i;
                }
                if(num==1) break;
            }
            if(num!=1) res.append(num);
            if(res.charAt(res.length()-2)=='*'){
                res.deleteCharAt(res.length()-1);
                res.deleteCharAt(res.length()-1);
            }
            System.out.println(res.toString());
        }
    }
    public static void main1(String[] args) {
        //美国节日
        /**
         * 2014-01-01
         * 2014-01-20
         * 2014-02-17
         * 2014-05-26
         * 2014-07-04
         * 2014-09-01
         * 2014-11-27
         * 2014-12-25
         *
         * 2013-01-01
         * 2013-01-21
         * 2013-02-18
         * 2013-05-27
         * 2013-07-04
         * 2013-09-02
         * 2013-11-28
         * 2013-12-25
         */
        Scanner scanner = new Scanner(System.in);
        String[] strings = new String[8];
        strings[0] = "-01-01";
        strings[1] = "-01-21";
        strings[2] = "-02-18";
        strings[3] = "-05-27";
        strings[4] = "-07-04";
        strings[5] = "-09-02";
        strings[6] = "-11-28";
        strings[7] = "-12-25";
        while(scanner.hasNext()){
            String y = scanner.nextLine();
            for (String s:strings) {
                System.out.println(y+s);
            }
        }
    }
}
