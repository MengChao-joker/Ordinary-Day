package java_5_13;

import java.util.*;

public class Gift {
    /**
     * 编程题]微信红包
     * 算法知识视频讲解
     * 春节期间小明使用微信收到很多个红包，非常开心。在查看领取红包记录时发现，某个红包金额出现的次数超过了红包总数的一半。请帮小明找到该红包金额。写出具体算法思路和代码实现，要求算法尽可能高效。
     * 给定一个红包的金额数组gifts及它的大小n，请返回所求红包的金额。
     * 若没有金额超过总数的一半，返回0。
     * 测试样例：
     * [1,2,3,2,2],5
     * 返回：2
     * @param gifts
     * @param n
     * @return
     */
    public int getValue(int[] gifts, int n) {
        int vote = 0;



        Map<Integer,Integer> map = new HashMap<>();
        int pos = gifts.length>>1;
        for (int num:gifts){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for (int num:gifts){
            if(map.get(num)>pos){
                return num;
            }
        }
        return 0;
    }
}
