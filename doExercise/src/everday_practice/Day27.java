package everday_practice;

import java.util.Scanner;

public class Day27 {
    /**
     * 1.缺页中断就是要访问的页不在主存，需要操作系统将其调入主存后再进行访问。
     * 在这个时候，被内存映射的文件实际上成了一个分页交换文件。
     *
     * 2.在使用锁保证现场安全时可能会出现 活跃度 失败的情况主要包括 饥饿、丢失信号、和活锁、死锁 等。
     * 【多线程除了死锁之外遇到最多的就是活跃度问题了】
     * 饥饿 ：指线程需要访问的资源 被永久拒绝 ，以至于不能再继续进行。(多线程抢占式调度，优先级低的线程一直得不到锁)
     * 解决饥饿问题需要平衡线程对资源的竞争，如线程的优先级、任务的权重、执行的周期等。
     * 活锁 ：指线程虽然没有被阻塞，但由于某种条件不满足，一直尝试重试却始终失败。
     * 解决活锁问题需要对 重试机制 引入一些随机性。例如如果检测到冲突，
     * 那么就暂停随机的一定时间进行重试，这会大大减少碰撞的可能性。
     * @param args
     */
    public static void main(String[] args) {
        //判断三角行

        Scanner scanner = new Scanner(System.in);
        double[] nums = new double[3];
        while(scanner.hasNext()){
            nums[0] = scanner.nextDouble();
            nums[1] = scanner.nextDouble();
            nums[2] = scanner.nextDouble();
            if(isTriangle(nums)){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }

    }
    private static boolean isTriangle(double[] nums) {
        double a = nums[0];
        double b = nums[1];
        double c = nums[2];
        if(a+b<=c||a+c<=b||c+b<=a){
            return false;
        }
        return true;
    }

    /**
     * 题目描述
     * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
     * 示例1
     * 输入
     * 1,2
     * 返回值
     * 3
     * @param args
     */
    public int Add(int num1,int num2) {
        while(num2!=0){
            int temp = num1^num2;
            num2 = (num1&num2)<<1;
            num1 = temp;

        }
        return num1;

    }
}
