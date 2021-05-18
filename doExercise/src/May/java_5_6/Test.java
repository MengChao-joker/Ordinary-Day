package java_5_6;

import java.util.*;

public class Test {
//先帮父类构造 父类的静态代码块 子类的静态代码块
//           父类的变量 父类的构造方法 子类的变量 子类的构造方法
    static class A{
        B b = new B();
        static {
            System.out.println("父类的静态代码块");
        }
    {
        System.out.println("构造代码块");
    }

        public A() {
            System.out.println("A");
        }
    }
    static class B{
        public B() {
            System.out.println("B");
        }
    }
    static class D{
        public D() {
            System.out.println("D");
        }
    }
    static class C extends A{
        D b = new D();
        static {
            System.out.println("子类的静态代码块");
        }
        public C() {
            System.out.println("C");
        }
    }

    public static void main(String[] args) {
        Integer i = new Integer(2);
        int a = 2;
//        new C();
        D d = new D();
        D d1 = new D();
        String s = "asd";
        String s1 = new String("asd");
        System.out.println(s.equals(s1));
        System.out.println(d.equals(d1));

    }


    public static void main3(String[] args) {
        //HashMap的简单使用
        Map<String,String> map = new HashMap<>();
        //插入元素:返回值为当下key所对应的value值，没有则返回null
        System.out.println(map.put("刘备", "玄德"));
        System.out.println(map.put("刘备", "玄德"));
        map.put("曹操","孟德");
        map.put("孙权","仲谋");
        map.put("吕布","奉先");
        //获取元素：返回值为当下key所对应的value值，没有则返回null
//        System.out.println(map.get("刘备"));
//        System.out.println(map.get("hehe"));
        //获取元素，没有则赋予默认值
//        System.out.println(map.getOrDefault("赵云", "子龙"));
//        System.out.println(map.get("赵云"));
        //查询key键是否存在
        System.out.println(map.containsKey("曹操"));
        //查询value键是否存在
        System.out.println(map.containsValue("仲谋"));
//        //清空操作
//        System.out.println(map);
//        map.clear();
//        System.out.println("清空后");
//        System.out.println(map);
//        //得到一个当前map的keySet集合
//        Set<String> set = map.keySet();
//        System.out.println(set);
//        //删除元素
//        System.out.println(map.remove("曹操"));
//        System.out.println(map);
        Iterator<Map.Entry<String,String>> iterator = map.entrySet().iterator();
        System.out.println("iterator打印map");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println();
        Set<Map.Entry<String,String>> set1 = map.entrySet();
        for (Map.Entry<String,String> entry:set1
             ) {
            System.out.println(entry);
        }

    }


    public static void main2(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(2,5);
        map.put(3,6);
        System.out.println(map.get(3));

    }


    public static void main1(String[] args) {
        Sex sex = Sex.Female;
        if(sex == Sex.Male){
            System.out.println("我是男性~");
        }else {
            System.out.println("我不是男性~");
        }
        System.out.println(Arrays.toString(Sex.values()));
    }
}
