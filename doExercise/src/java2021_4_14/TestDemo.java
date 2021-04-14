package java2021_4_14;

import java.util.HashMap;
import java.util.Map;

public class TestDemo {
    public static void main(String[] args) {
        System.out.print("www");
        System.out.print("\n");
        /*//字符码ascii 比较大小
        String s = "asdf";
        System.out.println(s.charAt(0)>97);*/

        /*//引用的赋值：该引用指向了新的对象
        StringBuilder res = new StringBuilder();
        StringBuilder tem = new StringBuilder();
        res = tem;
        res.append(1);
        System.out.println(tem.toString());*/

        /*//Map:getDefault方法：获取value或没有则设置默认值
        Map<Integer,Integer> map = new HashMap<>();
        int count = map.getOrDefault(1,5)+1;
        map.put(1,count);
        System.out.println(map.getOrDefault(1, 0)+1);*/
    }
}
