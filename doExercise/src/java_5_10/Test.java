package java_5_10;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

public class Test {
    private static String common;
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) throws InterruptedException {
        common = "main";
        threadLocal.set("我是main的局部变量~");
        Thread thread = new Thread("jmc"){
            @Override
            public void run() {
                common = "jmc";
                threadLocal.set("我是jmc的局部变量~");
                System.out.println(threadLocal.get());
            }
        };
        thread.start();
        thread.join();
        System.out.println(common);
        System.out.println(threadLocal.get());


    }
    public static void main2(String[] args) throws Exception {
        //指定初始容量15来创建一个HashMap
        HashMap<String, String> m = new HashMap<>(10);
        //获取HashMap整个类
        Class<?> mapType = m.getClass();
        //获取指定属性，也可以调用getDeclaredFields()方法获取属性数组
        Field threshold = mapType.getDeclaredField("threshold");
        //将目标属性设置为可以访问
        threshold.setAccessible(true);
        //获取指定方法，因为HashMap没有容量这个属性，但是capacity方法会返回容量值
        Method capacity = mapType.getDeclaredMethod("capacity");
        //设置目标方法为可访问
        capacity.setAccessible(true);
        //打印刚初始化的HashMap的容量、阈值和元素数量
        System.out.println("容量：" + capacity.invoke(m) + "    阈值：" + threshold.get(m) + "    元素数量：" + m.size());
        for (int i = 0; i < 17; i++) {
            m.put("asd"+i, "qwe"+i);
            //动态监测HashMap的容量、阈值和元素数量
            System.out.println("容量：" + capacity.invoke(m) + "    阈值：" + threshold.get(m) + "    元素数量：" + m.size());
        }
    }


    public static void main1(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        List<String> list = Arrays.asList(
                "asd", "b", "as"
        );
        ArrayList<String> l = new ArrayList<>();
        l.add("asd");
        l.add("asdf");
        for (String s : l) {
//            l.add("asd");
            System.out.println(s);
        }
//        int i = 1;
//        System.out.println(l.remove(1));
//        list.add("qwe");
//        System.out.println(list);
//        System.out.println(list.remove(1));
//        System.out.println(list);
//        for (String s : list) System.out.println(s);
        System.out.println(map.get(null));
        System.out.println(map.size());
        map.put(null, null);
        System.out.println(map.size());
        System.out.println(map.get(null));
    }
}

