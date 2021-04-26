package java_4_26;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            int len = 0;
            int flag = 0;
            for (int i = 0; i < str.length(); i++) {

                if (str.charAt(i) == '\"') {
                    stringBuilder.append('\"');
                    flag++;
                    continue;
                }
                if (str.charAt(i) != ' ') {
                    stringBuilder.append(str.charAt(i));
                } else if (str.charAt(i) == ' ' && flag % 2 == 0) {
                    stringBuilder.append('\n');
                    len++;
                } else {
                    stringBuilder.append(' ');
                }
            }
            System.out.println(len+1);
            System.out.println(stringBuilder.toString());
        }
    }
}
