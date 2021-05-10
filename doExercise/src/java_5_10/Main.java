package java_5_10;

import java.util.*;

public class Main {
    /**
     * 问题：有两个字符串str和str2，求出两个字符串中最长公共子串长度。
     * 比如：str=acbcbcef，str2=abcbced，则str和str2的最长公共子串为bcbce，最长公共子串长度为5。
     * 算法思路：
     * 1、把两个字符串分别以行和列组成一个二维矩阵。
     * 2、比较二维矩阵中每个点对应行列字符中否相等，相等的话值设置为1，否则设置为0。
     * 3、通过查找出值为1的最长对角线就能找到最长公共子串。
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            String ret = maxSame(str1,str2);
            System.out.println(ret);

        }

    }

    private static String maxSame(String str1, String str2) {
        int[][] array = new int[str1.length()][str2.length()];
        int maxLen =0;
        int pos = 0;
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    if(i==0||j==0){
                        array[i][j] = 1;
                    }else {
                        array[i][j] = 1+array[i-1][j-1];
                    }
                }else {
                    array[i][j] = 0;
                }
                if(array[i][j]>maxLen){
                    maxLen = array[i][j];
                    pos = i;
                }
            }
        }
        return str1.substring(pos-maxLen+1,pos+1);
    }


    //汽水瓶
    /**
     * 题目：有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。小张手上有十个空汽水瓶，
     * 她最多可以换多少瓶汽水喝？”答案是5瓶，方法如下：先用9个空瓶子换3瓶汽水，喝掉3瓶满的，
     * 喝完以后4个空瓶子，用3个再换一瓶，喝掉这瓶满的，这时候剩2个空瓶子。
     * 然后你让老板先借给你一瓶汽水，喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。
     * 如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝？
     */
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        while(scanner.hasNext()){
            int count = scanner.nextInt();
            if(count==0){
                break;
            }else {
                queue.add(count);
            }
        }
        func(queue);
    }

    private static void func(Queue<Integer> queue) {
        while(!queue.isEmpty()){
            int temp = queue.poll();
            System.out.println(outPut(temp));
        }

    }
    private static int outPut(int temp) {
        if(temp<2) return 0;
        if(temp==2) return 1;
        return (temp / 3) + outPut(temp/3+temp%3);
    }

    private static void outPut1(int temp) {
        if(temp<2) {
            System.out.println(0);
            return;
        }
        if(temp == 2) {
            System.out.println(1);
            return;
        }
        int sum = 0;
        while(temp>=3){
            sum+=temp/3;
            temp = (temp/3+temp%3);
            if(temp==2){
                sum++;
                break;
            }

        }
        System.out.println(sum);
    }
}
