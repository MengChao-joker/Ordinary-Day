package May.java_5_18;

public class Test3 {
    public static final int _1MB = 1024*1024;
//-XX:+PrintGCDetails -XX:+UseSerialGC -Xms20M -Xmx20M -Xmn10M -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
    //-XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3;
        System.out.println("");
        allocation1 = new byte[_1MB/4];//Eden
        allocation2 = new byte[4*_1MB];//Eden
        System.out.println("第一次Minor GC1");
        allocation3 = new byte[4*_1MB];//Minor GC1（担保机制s区存储不下的对象直接进入老年代）
        System.out.println("第二次Minor GC2");
//        allocation3 = null;
        System.out.println(3);
        allocation3 = new byte[4*_1MB];//Minor GC2（担保机制s区存储不下的对象直接进入老年代）

    }
}
