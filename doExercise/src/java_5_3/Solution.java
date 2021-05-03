package java_5_3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Solution {

    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //放入键值对第一次value为1   第二次为2...
            if(map.get(nums[i])==null){
                map.put(nums[i],1);
            }else {
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        /*//循环取出键值对Entry 判断value为1 则返回key
        for (Map.Entry<Integer,Integer> entry:map.entrySet()
             ) {
            if(entry.getValue().equals(1)) {
               return entry.getKey();
            }
        }*/

        //迭代器
        Iterator<Map.Entry<Integer,Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,Integer> entry = iterator.next();
            if(entry.getValue().equals(1)){
                return entry.getKey();
            }
        }
        return 0;
    }


}
