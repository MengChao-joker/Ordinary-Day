package April.java_4_17;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int a = scanner.nextInt();
            int[] nums = new int[a];
            for (int i = 0; i < a; i++) {
                nums[i]=scanner.nextInt();
            }
            int sum = 0; int max = nums[0];
            for (int i = 0; i < a; i++) {
                sum+=nums[i];
                max = max>sum?max:sum;
                if(sum<0){
                    sum = 0;
                }

            }
        }
    }

    public static void main1(String[] args) {
        String s = "asd";
        StringBuffer s1 = new StringBuffer("asdf");
        System.out.println(s.substring(0,1));
        System.out.println(s1.substring(0,0));

    }
    //判断回文
    public static void main2(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String str1 = s.nextLine();
            String str2 = s.nextLine();
            int res = 0;
            String s1 = "";
            for (int i = 0; i < str1.length(); i++) {
                s1 = str1.substring(0, i) + str2 + str1.substring(i, str1.length());
                StringBuilder stringBuilder = new StringBuilder(s1);
                if (stringBuilder.reverse().toString().equals(s1)) res++;
            }
            System.out.println(res);
        }
    }
}
