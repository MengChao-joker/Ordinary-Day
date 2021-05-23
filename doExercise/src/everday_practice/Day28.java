package everday_practice;

import java.util.Arrays;
import java.util.Scanner;

public class Day28 {
    /**
     * 思路：因为每次分5堆都会多出来1个，所以我们借给猴子们4个，以致每次都可以刚好分成5堆
     *     并且，每次给老猴子的桃子都不在我们借出的那4个中，这样最后减掉4就可以得到结果。
     *   假设最初由x个桃子，我们借给猴子4个，则此时有x+4个，
     *   第一个猴子得到（x+4）/5，剩余（x+4）*（4/5）个
     *   第二个猴子分完后剩余（x+4）*(4/5)^2个
     *   第三个猴子分完后剩余（x+4）*(4/5)^3个
     *   依次类推，最后一个猴子分完后剩余（x+4）*（4/5）^n
     *   要满足最后剩余的为整数，并且x最小，则当 x+4=5^n时，满足要求
     *   此时，x=5^n-4;
     *   老猴子得到的数量为：old = （x+4）*（4/5）^n + n - 4
     *                     = 4^n + n - 4
     *   最后加n是因为不是剩余多出来的一个，而是小猴子给的，比如桃子是有6个，小猴子本身只能拿一个，我们借给4个，小猴就能拿两个，那多出来的哪一个给老猴子，和之前6个整除五余1一个道理
     *   最后老猴子减4是还给我们借给它们的那4个
     *
     */
        public static void main1(String[] args) {
            Scanner sc = new Scanner(System.in);
            long n = 0;
            while(sc.hasNext()){
                n = sc.nextInt();
                if(n == 0)
                    break;
                long a = (long)Math.pow(5, n);
                long b = (long)Math.pow(4, n);
                System.out.println((a-4)+" "+(b-4+n));
            }
        }

    /**
     * 1.减少换页错误：使用最短时间的调度机制(时间长了，缓存到的数据不够，就会发生换页错误)
     * 2.储存保护：不同程序间不能互相访问私有的资源
     * 3.信号量：n个进程，只有一个进程再工作，信号量就为n-1，即等待进程的个数
     */

    /**
     * 奇数位上都是奇数或者偶数位上都是偶数
     * 给定一个长度不小于2的数组arr。 写一个函数调整arr，
     * 使arr中要么所有的偶数位上都是偶数，要么所有的奇数位上都是奇数上。
     * 要求：如果数组长度为N，时间复杂度请达到O(N)，额外空间复杂度请达到O(1),
     * 下标0,2,4,6...算作偶数位,下标1,3,5,7...算作奇数位，
     * 例如[1,2,3,4]调整为[2,1,4,3]即可
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4,5,6,4,8,5,2,4,8,5};
        oddInOddEvenInEven2(arr);
        System.out.println(Arrays.toString(arr));
//        [2, 5, 4, 1, 6, 3, 8, 5, 4, 5, 2, 8, 4]


    }

    /**
     * 奇数位上都是奇数或者偶数位上都是偶数
     * 输入：数组arr，长度大于2
     * 将arr调整成奇数位上都是奇数或者偶数位上都是偶数
     */
    public static void oddInOddEvenInEven2(int[] arr) {
        if(arr==null||arr.length<2) return;
        int end = arr.length-1;
        int ji = 1;
        int ou = 0;
        while(ji<=end&&ou<=end) {
            if (arr[end] % 2 == 1) {
                swap(arr, ji, end);
                ji += 2;
            }else {
                swap(arr,ou,end);
                ou+=2;
            }
        }
    }
    public static void swap(int[]array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void oddInOddEvenInEven(int[] arr) {
        int ji = 1;
        int ou = 0;
        while (ji < arr.length && ou < arr.length) {
            if (arr[ji] % 2 == 0 && arr[ou] % 2 != 0) {
                int temp = arr[ji];
                arr[ji] = arr[ou];
                arr[ou] = temp;
                ji += 2;
                ou += 2;
                continue;//判断下表是否越界
            }
            if (arr[ji] % 2 == 1) {
                ji += 2;
            }
            if (arr[ou] % 2 == 0) {
                ou += 2;
            }


        }


    }


}
