package java_4_29;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        //多态的体现：向上转型
        List<String> list = new ArrayList<>();
        //1.add()添加操作
        list.add("平凡的一天");
        list.add("给你给我");
        list.add("");
        //2.set()向指定位置插入元素 get()去指定下标的元素
        list.set(2,"想你想你");
        System.out.println(list.get(2));
        //切分操作
        System.out.println(list.subList(1, 2));

        /*//3.循环输出
        for (String s:list
             ) {
            System.out.println(s);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }*/
        //4.删除元素
        System.out.println("删除前：");
        System.out.println(list);
        list.remove(1);
        System.out.print("删除后：");
        System.out.println(list);

        System.out.println(list.contains("消愁"));

        Object[] objects = list.toArray();

        String[] strings = new String[]{""};
        System.out.println(strings instanceof Object[]);
        System.out.println(objects[1]);

    }
}
