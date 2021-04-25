package java_4_24;

import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        byte b = 127;
        //byte b = 128 ERROR byte取值范围：-128~127
        System.out.println(b);
    }
    
    
    public static void main2(String[] args) {
        //输入一个正整数，判断其二进制中最大连续1的个数
        Scanner s = new Scanner(System.in);
        while (s.hasNext()){
            int x = s.nextInt();
            int max = 0;
            int res = 0;
            while(x!=0){
            if(x%2==1){
                max++;
                res = Math.max(res,max);
            }else{
                max=0;
            }
            x/=2;
            }
            System.out.println(res);
        }
    }


    public static void main1(String[] args) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("name","AC");
        map.put("name","ACK");
        map.put("test","ACK");
        System.out.println(map.size());
        System.out.println(map.remove("name"));
        System.out.println(map.remove("test"));
        System.out.println(map.size());
    }
}
