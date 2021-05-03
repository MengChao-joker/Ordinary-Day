package java_5_3;

import java.util.HashMap;
import java.util.Map;

public class MySet {
    public static void main(String[] args) {
        Map<String,String> map= new HashMap<>();
        map.put("jmc","金萌超");
        System.out.println(map.entrySet());
    }
}
