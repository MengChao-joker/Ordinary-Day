package java_5_24;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    //657. 机器人能否返回原点
    //https://leetcode-cn.com/problems/robot-return-to-origin/
    public boolean judgeCircle(String moves) {
        int a = 0;
        int b = 0;
        for(int i=0;i<moves.length();i++){
            char c = moves.charAt(i);
            switch(c){
                case 'L':a--; break;
                case 'R':a++; break;
                case 'U':b++; break;
                case 'D':b--; break;
            }
        }
        if(a==0&&b==0){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 1436. 旅行终点站
     * https://leetcode-cn.com/problems/destination-city/
     */
    public String destCity(List<List<String>> paths) {
        if(paths==null) return null;
        Map<String,String> map = new HashMap<>();
        for(List<String> list:paths){
            map.put(list.get(0), list.get(1));
        }
        String start = paths.get(0).get(0);
        while(map.get(start)!=null){
            start = map.get(start);
        }
        return start;
    }

    /**
     * 1013. 将数组分成和相等的三个部分
     * https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum/
     * @param arr
     * @return
     */


    public static boolean canThreePartsEqualSum(int[] arr) {
        //贪心算法：找出前n项和为sum/3再从i+1出发找到和为sum/3,即可返回true
        int sum = 0;
        int len = arr.length;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        if(sum%3!=0) return false;
        int cur = 0;
        int j= 0;
        while(j<len){
            cur += arr[j];
            if(cur==sum/3) break;
            j++;
        }
        if(cur!=sum/3) return false;
        cur = 0;
        j = j+1;
        while(j+1<len){
            cur += arr[j];
            if(cur==sum/3) {
                return true;
            }
            j++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {3,3,6,5,-2,2,5,1,-9,4};
        System.out.println(canThreePartsEqualSum(arr));
    }



}
