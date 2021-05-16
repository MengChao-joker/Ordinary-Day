package java_5_14;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String s = scanner.nextLine();
            Map<Character,Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c =s.charAt(i);
                map.put(c,map.getOrDefault(c,0)+1);
            }
            for (int i = 0; i < s.length(); i++) {
                if(map.get(s.charAt(i))==1){
                    System.out.println(s.charAt(i));
                    return;
                }
            }
            System.out.println(-1);
        }

    }
    /**
     * 链接：https://www.nowcoder.com/questionTerminal/fe6c73cb899c4fe1bdd773f8d3b42c3d?orderByHotValue=1&amp;questionTypes=000100&amp;mutiTagIds=1213&amp;page=8&amp;onlyReference=false*
     * [编程题]小易的升级之路
     * 热度指数：31909时间限制：C/C++ 1秒，其他语言2秒空间限制：C/C++ 32M，其他语言64M
     * 算法知识视频讲解
     * 小易经常沉迷于网络游戏.有一次,他在玩一个打怪升级的游戏,他的角色的初始能力值为 a.在接下来的一段时间内,他将会依次遇见n个怪物,每个怪物的防御力为b1,b2,b3...bn. 如果遇到的怪物防御力bi小于等于小易的当前能力值c,那么他就能轻松打败怪物,并 且使得自己的能力值增加bi;如果bi大于c,那他也能打败怪物,但他的能力值只能增加bi 与c的最大公约数.那么问题来了,在一系列的锻炼后,小易的最终能力值为多少?
     * 输入描述:
     * 对于每组数据,第一行是两个整数n(1≤n<100000)表示怪物的数量和a表示小易的初始能力值.
     * 第二行n个整数,b1,b2...bn(1≤bi≤n)表示每个怪物的防御力
     * 输出描述:
     * 对于每组数据,输出一行.每行仅包含一个整数,表示小易的最终能力值
     * 示例1
     * 输入
     * 3 50
     * 50 105 200
     * 5 20
     * 30 20 15 40 100
     * 输出
     * 110
     * 205
     * @param args
     */
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String s = scanner.nextLine();
            String s1 = scanner.nextLine();
            String[] role = s.split(" ");
            String[] bosses = s1.split(" ");
            int ret = Integer.parseInt(role[1]);
            for (String boss: bosses) {
                int temp = Integer.parseInt(boss);
                if(ret>=temp){
                    ret+=temp;
                }else {
                    ret+=gcd(ret,temp);
                }
            }
            System.out.println(ret);
        }
    }
    private static int gcd(int ret, int temp) {
        while(temp%ret!=0){
            int left = temp%ret;
            temp = ret;
            ret = left%ret;
        }
        return ret;
    }
}
