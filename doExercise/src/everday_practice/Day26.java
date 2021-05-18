package everday_practice;

import java.util.Scanner;

public class Day26 {
    /**
     *  1.操作系统采用缓冲区技术的主要目的是为了提高cup和设备间的并发程度，从而提高计算机的效率
     *  2.操作系统的主要功能：文件管理，作业管理，设备管理，存储器管理，处理器管理
     *
     * @param args
     */


    public static void main(String[] args) {
        /**
         * 小喵们很喜欢把自己装进容器里的（例如碗），但是要是碗的周长比喵的身长还短，它们就进不去了。
         * 现在告诉你它们的身长，和碗的半径，请判断一下能否到碗里去。
         * 输入描述:
         * 输入有多组数据。
         * 每组数据包含两个整数n (1≤n≤2^128) 和r (1≤r≤2^128)，分别代表喵的身长和碗的半径。
         * 圆周率使用3.14。
         * 输出描述:
         * 对应每一组数据，如果喵能装进碗里就输出“Yes”；否则输出“No”。
         * 示例1
         * 输入
         * 6 1
         * 7 1
         * 9876543210 1234567890
         * 输出
         * Yes
         * No
         * No
         */
        //采用double基本数据类型(double取值指数范围：-1023~1024)
        //   float基本数据类型(float取值指数范围：-127~128)
        Scanner s = new Scanner( System.in);
        while(s.hasNext()){
            double cat = s.nextDouble();
            double bowl = s.nextDouble();
            if(fit(cat,bowl))
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }

    private static Boolean fit(double cat, double bowl) {
        double l = bowl*2*3.14;
        return l>=cat;
    }
}





