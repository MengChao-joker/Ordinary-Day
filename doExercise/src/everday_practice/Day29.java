package everday_practice;

import java.util.Scanner;

public class Day29 {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            while (input.hasNext()) {
                int n = input.nextInt();
                if (isPrimer(n)) {
                    System.out.println(1);
                    continue;
                }
                int cnt = 0;
                for (int i = 2; i <= Math.sqrt(n); i++) {
                    if (n % i == 0) {
                        while (n % i == 0) {
                            n /= i;
                        }
                        cnt++;
                    }
                }
                if (n != 1) cnt++;
                System.out.println(cnt);
            }
        }

        public static boolean isPrimer(int n) {
            for (int i = 2; i <= Math.pow(n, 0.5); i++) {
                if (n % i == 0) return false;
            }
            return true;
        }
    /**
     * NowCoder生活在充满危险和阴谋的年代。为了生存，他首次发明了密码，用于军队的消息传递。假设你是军团中的一名军官，需要把发送来的消息破译出来、并提
     * 供给你的将军。
     * 消息加密的办法是：对消息原文中的每个字母，分别用该字母之后的第5个字母替换（例如：消息原文中的每个字母A 都分别替换成字母F），其他字符不 变，并且消息原文的所有字母都是大写的。密码中的字母与原文中的字母对应关系如下。
     * 密码字母：A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
     * 原文字母：V W X Y Z A B C D E F G H I J K L M N O P Q R S T U
     * 输入描述:
     * 输入包括多组数据，每组数据一行，为收到的密文。
     * 密文仅有空格和大写字母组成。
     * 输出描述:
     * 对应每一组数据，输出解密后的明文。
     * 示例1
     * 输入
     * HELLO WORLD
     * 输出
     * CZGGJ RJMGY
     */
    public static void main2(String[] args) {
        dQ();
    }
    public static void dQ(){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String code = scanner.nextLine();
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < code.length(); i++) {
                char temp = code.charAt(i);
                if (temp == ' ') {
                    res.append(" ");
//                    System.out.print(temp);
                    continue;
                }
                if (temp > 'E') {
                    res.append((char) (temp - 5));

//                    System.out.print((char) (temp - 5));
                } else {res.append((char) (temp + 21));

//                    System.out.print((char) (temp + 21));
                }
            }
            System.out.println(res.toString());
        }
    }
}
