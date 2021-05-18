package everday_practice;

import java.util.Scanner;

public class Day26 {
    /**
     *  1.操作系统采用缓冲区技术的主要目的是为了提高cup和设备间的并发程度，从而提高计算机的效率
     *  2.操作系统的主要功能：文件管理，作业管理，设备管理，存储器管理，处理器管理
     *
     * @param args
     */


    public static void main2(String[] args) {
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

    /**
     * 变态跳台阶
     * 题目描述
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法
     * 解题思路
     *  可以延续上一题的思路，逆向思维来考虑这个问题。要想跳到第n级台阶，就可以从第n-1级、第n-2级、***、第1级 跳到第n级，再加上直接从地面到第n级的一种情况。
     * 将问题分解为求子问题这是递归。所以有如下三种方法：
     *    方法一：用传统递归法求解
     *    方法二：将递归化为非递归方法，用双重循环
     *    方法三：满足动态规划条件，进一步降低时间复杂度
     *                分析出递归条件：    我们用f(n)来表示跳n级台阶的跳法数量，
     *
     *     f(1)=1表示跳1级台阶的跳法数量;
     *     f(2)=2表示跳2级台阶的跳法数量;
     *     f(3)=f(2)+f(1)+1  我们可以递推出  f(n)=f(n-1)+f(n-2)+ ... +f(1)+1 ,
     *     而f(n-1)=f(n-2)+ ... +f(1)+1。
     * 将两式想减可以求出递推公式，也即是 f(n)-f(n-1)=f(n-1)，即f(n)=2*f(n-1); 所以自底向上的动态规划方法浮出眼前。

     * @param target
     * @return
     */

    public static void main(String[] args) {
        System.out.println(Math.pow(2, 99));
        System.out.println(jumpFloorII(100));
        System.out.println(jumpFloorII2(100));
    }

    public static double jumpFloorII(double target) {
        /**
         * 动规思路:找出规律：即f(n)=f(n-1)+f(n-2)+...+f(1)+1
         *                f(n-1)=f(n-2)+f(n-3)+...+f(1)+1
         *           f(n)-f(n-1)=f(n-1)
         *                  f(n)=2*f(n-1)
         */
        if(target<2) return target;
        double[] arrays = new double[(int)target+1];
        arrays[1] = 1;
        for (int i = 2; i < target+1; i++) {
            arrays[i] = 2*arrays[i-1];
        }
        return arrays[(int)target];
    }
    public static int jumpFloorII2(int target) {
        if(target<2){
            return 1;
        }
        int sum = 0;
        for (int i = 0; i < target; i++) {
            sum+=jumpFloorII2(i);
        }
        return sum;
//        return 2*jumpFloorII2(target-1);

    }

    /*//变态跳台阶

        //方法一、非递归方法
        public static  int jumpFloorII3(int number) {
            if(number==0){
                return 0;
            }
            int a[] = new int[number];
            for(int i=0;i<number;i++){
                int sum = 0;
                for(int j=0;j<i;j++){
                    sum += a[j];
                }
                a[i]=sum+1;
            }
            return a[number-1];
        }

        //方法三、动态规划方法    自底向上
        public static int JumpFloor(int target){
            if(target==0){   //如果为0层台阶时，返回0
                return 0;
            }
            int a[] = new int[target+2];   //加2的原因是下面的a数组要初始化到第三个元素
            int b=3;
            a[0]=1;
            a[1]=1;
            a[2]=2;
            if(target<b&&target>0){
                return a[target];
            }
            for(int i=3;i<=target;i++){
                a[i]=2*a[i-1];
            }
            return a[target];
        }*/


}





